package com.technokratos.service;

import com.technokratos.dto.response.UserResponse;

public interface TokenAuthorizationService {
    UserResponse getUserInfoByToken(String token);
}
