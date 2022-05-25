package com.technokratos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ApartmentPhotoService {

    String upload(MultipartFile photo, UUID apartmentId, UserDetails userPrincipal);

    void delete(String photoId, UUID apartmentId, UserDetails userPrincipal);

    void deleteAll(UUID apartmentId, UserDetails userPrincipal);

    List<String> getAll(UUID apartmentId);
}

