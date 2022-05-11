package com.technokratos.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserApi {

    @PostMapping("/user/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    String avatarUpload(@RequestParam("photo") MultipartFile photo, @PathVariable("id") UUID userId);

    @DeleteMapping("/user/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    void avatarDelete(@PathVariable("id") UUID userId);
}
