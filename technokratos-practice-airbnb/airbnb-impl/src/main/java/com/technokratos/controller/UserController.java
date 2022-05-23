package com.technokratos.controller;

import com.technokratos.api.UserApi;
import com.technokratos.service.UserPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserPhotoService userPhotoService;

    @Override
    public String uploadAvatar(MultipartFile photo, UUID userId) {
        return userPhotoService.upload(photo, userId);
    }

    @Override
    public void deleteAvatar(UUID userId) {
        userPhotoService.delete(userId);
    }
}
