package com.technokratos.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserApi<PRINCIPAL> {

    @PostMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    String uploadAvatar(@RequestParam("photo") MultipartFile photo,
                        @PathVariable("id") UUID userId,
                        @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @DeleteMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    void deleteAvatar(@PathVariable("id") UUID userId,
                      @AuthenticationPrincipal PRINCIPAL userPrincipal);
}
