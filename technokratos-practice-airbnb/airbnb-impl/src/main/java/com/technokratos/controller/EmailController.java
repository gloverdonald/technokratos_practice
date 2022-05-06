package com.technokratos.controller;

import com.technokratos.api.EmailApi;
import com.technokratos.dto.request.LoginRequest;
import com.technokratos.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController implements EmailApi {

    private final EmailService emailService;

    @Override
    public Boolean emailConfirmation(String confirmCode) {
        return emailService.confirm(confirmCode);
    }

    @Override
    public void getConfirmationToken(LoginRequest userRequest) {
        emailService.create(userRequest);
    }
}
