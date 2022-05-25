package com.technokratos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UserPhotoService {

    String upload(MultipartFile photo, UUID userId, UserDetails userPrincipal);

    void delete(UUID userId, UserDetails userPrincipal);

}
