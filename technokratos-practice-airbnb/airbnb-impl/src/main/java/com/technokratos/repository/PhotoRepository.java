package com.technokratos.repository;

import com.technokratos.model.PhotoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface PhotoRepository {

    String savePhoto(MultipartFile file) throws IOException;

    void delete(String id);

    Optional<PhotoEntity> findById(String id) throws IOException;

}
