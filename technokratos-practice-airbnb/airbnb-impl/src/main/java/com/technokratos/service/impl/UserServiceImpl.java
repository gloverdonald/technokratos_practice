package com.technokratos.service.impl;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.exception.RoleNotFoundException;
import com.technokratos.exception.UnauthorizedException;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.UserMapper;
import com.technokratos.model.RoleEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.RoleRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UUID create(RegistrationRequest userRequest) {
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
        return userRepository.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getHashPassword()))
                .map(userMapper::toResponse)
                .orElseThrow(() -> new UnauthorizedException("Can't login in: " + request.getEmail() + ". Wrong email or password."));
    }
}
