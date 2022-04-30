package com.technokratos.service;

import com.technokratos.dto.request.LoginRequest;

public interface EmailService {

    Boolean confirm(String confirmCode);

    void create(LoginRequest userRequest);
}
