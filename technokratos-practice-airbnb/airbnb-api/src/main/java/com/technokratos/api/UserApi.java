package com.technokratos.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserApi {

    @PostMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    String uploadAvatar(@RequestParam("photo") MultipartFile photo,
                        @PathVariable("id") UUID userId);

    @DeleteMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    void deleteAvatar(@PathVariable("id") UUID userId);
}
