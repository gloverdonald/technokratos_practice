package com.technokratos.service.impl;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.exception.*;
import com.technokratos.mapper.UserMapper;
import com.technokratos.model.ConfirmationTokenEntity;
import com.technokratos.model.RoleEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ConfirmationTokenRepository;
import com.technokratos.repository.RoleRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.UserService;
import com.technokratos.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public UUID create(RegistrationRequest userRequest) {
        userRepository.findByEmail(userRequest.getEmail()).orElseThrow(UserAlreadyExistsException::new);
        UserEntity user = userMapper.toEntity(userRequest);
        user.setHashPassword(passwordEncoder.encode(userRequest.getPassword()));
        List<RoleEntity> roles = userRequest.getRoles()
                .stream()
                .map(role -> roleRepository.findByRole(role).orElseThrow(RoleNotFoundException::new))
                .toList();
        user.setRoles(roles);
        return userRepository.save(user).getId();
    }

    @Override
    public UserResponse login(LoginRequest request) {
        UserEntity userEntity = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new UnauthorizedException("Can't login in: " + request.getEmail() + ". Wrong email or password."));

        if (userEntity.getVerified()) {
            if (passwordEncoder.matches(request.getPassword(), userEntity.getHashPassword())) {
                return userMapper.toResponse(userEntity);
            } else
                throw new UnauthorizedException("Can't login in: " + request.getEmail() + ". Wrong email or password.");
        } else {
            throw new ConfirmEmailException();
        }

    }
}
