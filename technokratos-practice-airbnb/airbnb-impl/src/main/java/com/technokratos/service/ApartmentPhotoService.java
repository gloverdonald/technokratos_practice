package com.technokratos.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface ApartmentPhotoService {

    String upload(MultipartFile photo, UUID apartmentId);

    void delete(String photoId, UUID apartmentId);

    void deleteAll(UUID apartmentId);

    List<String> getAll(UUID apartmentId);
}

