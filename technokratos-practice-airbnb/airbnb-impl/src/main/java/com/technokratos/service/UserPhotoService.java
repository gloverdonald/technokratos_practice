package com.technokratos.service;

import com.technokratos.dto.response.PhotoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UserPhotoService {

    String upload(MultipartFile photo, UUID userId);

    void delete(UUID userId);

}
