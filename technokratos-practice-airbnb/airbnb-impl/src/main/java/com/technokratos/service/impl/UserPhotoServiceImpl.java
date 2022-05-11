package com.technokratos.service.impl;

import com.technokratos.dto.response.PhotoResponse;
import com.technokratos.exception.*;
import com.technokratos.mapper.PhotoMapper;
import com.technokratos.model.PhotoEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.PhotoRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.UserPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserPhotoServiceImpl implements UserPhotoService {

    private final PhotoRepository photoRepository;

    private final UserRepository userRepository;

    @Override
    public String upload(MultipartFile photo, UUID userId) {
        if (photo.isEmpty() || photo.getSize() == 0) {
            throw new PhotoIsEmptyException();
        }
        if (!(photo.getContentType().equals("image/jpeg")
                || photo.getContentType().equals("image/png"))) {
            throw new UnsupportedMediaTypeException();

        }
        try {
            UserEntity user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
            String id = photoRepository.savePhoto(photo);
            if (photoRepository.findById(user.getAvatarId()).isPresent()) {
                photoRepository.delete(user.getAvatarId());
            }
            user.setAvatarId(id);
            userRepository.save(user);
            return id;
        } catch (IOException e) {
            throw new PhotoUploadException();
        }
    }

    @Override
    public void delete(UUID userId) {
        try {
            UserEntity user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
            if (photoRepository.findById(user.getAvatarId()).isPresent()) {
                photoRepository.delete(user.getAvatarId());
            }
            user.setAvatarId(null);
            userRepository.save(user);
        } catch (IOException e) {
            throw new PhotoNotFoundException();
        }
    }
}
