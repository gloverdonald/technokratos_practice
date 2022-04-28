package com.technokratos.service;

import com.technokratos.dto.request.LoginRequest;
import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {

    UUID create(RegistrationRequest userRequest);

    UserResponse login(LoginRequest loginRequest);
}
