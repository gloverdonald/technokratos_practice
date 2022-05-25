package com.technokratos.api;

import com.technokratos.dto.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/email/confirm")
public interface EmailApi {
    @GetMapping("/{confirm-code}")
    @ResponseStatus(HttpStatus.OK)
    Boolean emailConfirmation(@PathVariable("confirm-code") String confirmCode);

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void getConfirmationToken(@Valid @RequestBody LoginRequest userRequest);
}
