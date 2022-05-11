package com.technokratos.service.impl;

import com.technokratos.dto.response.PhotoResponse;
import com.technokratos.exception.*;
import com.technokratos.mapper.PhotoMapper;
import com.technokratos.model.PhotoEntity;
import com.technokratos.repository.PhotoRepository;
import com.technokratos.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    private final PhotoMapper photoMapper;

    @Override
    public String upload(MultipartFile photo) {
        if (photo.isEmpty() || photo.getSize() == 0) {
            throw new PhotoIsEmptyException();
        }
        if (!(photo.getContentType().equals("image/jpeg")
                || photo.getContentType().equals("image/png"))) {
            throw new UnsupportedMediaTypeException();

        }
        try {
            return photoRepository.savePhoto(photo);
        } catch (IOException e) {
            throw new PhotoUploadException();
        }
    }

    @Override
    public PhotoResponse download(String id) {
        try {
            PhotoEntity photoEntity = photoRepository.findById(id).orElseThrow(PhotoNotFoundException::new);
            return photoMapper.toResponse(photoEntity);
        } catch (IOException e) {
            throw new PhotoDownloadException();
        }
    }
}
