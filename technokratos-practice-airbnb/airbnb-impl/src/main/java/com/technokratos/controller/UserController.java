package com.technokratos.controller;

import com.technokratos.api.UserApi;
import com.technokratos.service.UserPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi<UserDetails> {

    private final UserPhotoService userPhotoService;

    @Override
    public String uploadAvatar(MultipartFile photo, UUID userId, UserDetails userPrincipal) {
        return userPhotoService.upload(photo, userId, userPrincipal);
    }

    @Override
    public void deleteAvatar(UUID userId, UserDetails userPrincipal) {
        userPhotoService.delete(userId, userPrincipal);
    }
}
