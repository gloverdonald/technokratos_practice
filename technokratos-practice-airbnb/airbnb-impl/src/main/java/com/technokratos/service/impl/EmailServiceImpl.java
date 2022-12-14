package com.technokratos.service.impl;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.exception.ConfirmCodeNotFoundException;
import com.technokratos.exception.ConfirmEmailException;
import com.technokratos.exception.EmailAlreadyConfirmedException;
import com.technokratos.exception.UnauthorizedException;
import com.technokratos.model.ConfirmationTokenEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ConfirmationTokenRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.EmailService;
import com.technokratos.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.confirm.url}")
    String emailUrl;

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailUtil emailUtil;

    @Override
    public Boolean confirm(String confirmCode) {
        ConfirmationTokenEntity confirmationToken = confirmationTokenRepository.findByToken(confirmCode)
                .orElseThrow(ConfirmCodeNotFoundException::new);
        UserEntity user = confirmationToken.getUser();
        if (user.getVerified()) {
            throw new EmailAlreadyConfirmedException();
        }
        user.setVerified(true);
        userRepository.save(user);

        return true;
    }

    @Override
    public void create(LoginRequest userRequest) {
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail())
                .orElseThrow(() ->
                        new UnauthorizedException("Can't login in: " + userRequest.getEmail() + ". Wrong email or password."));

        if (userEntity.getVerified()) {
            throw new EmailAlreadyConfirmedException();
        } else {
            if (passwordEncoder.matches(userRequest.getPassword(), userEntity.getHashPassword())) {
                ConfirmationTokenEntity token = ConfirmationTokenEntity.builder()
                        .token(UUID.randomUUID().toString())
                        .user(userEntity)
                        .build();
                confirmationTokenRepository.save(token);

                Map<String, Object> data = new HashMap<>();
                data.put("user", userEntity);
                data.put("confirmLink", emailUrl + token.getToken());

                emailUtil.sendMail(userEntity.getEmail(), "confirmation", "confirm_mail", data);
            } else
                throw new UnauthorizedException("Can't login in: " + userRequest.getEmail() + ". Wrong email or password.");

        }
    }
}