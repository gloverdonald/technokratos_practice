package com.technokratos.service.impl;

import com.technokratos.exception.*;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.ApartmentPhotoEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ApartmentPhotoRepository;
import com.technokratos.repository.ApartmentRepository;
import com.technokratos.repository.PhotoRepository;
import com.technokratos.service.ApartmentPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApartmentPhotoServiceImpl implements ApartmentPhotoService {

    private final ApartmentPhotoRepository apartmentPhotoRepository;

    private final PhotoRepository photoRepository;

    private final ApartmentRepository apartmentRepository;

    @Override
    public String upload(MultipartFile photo, UUID apartmentId) {
        if (photo.isEmpty() || photo.getSize() == 0) {
            throw new PhotoIsEmptyException();
        }
        if (!(photo.getContentType().equals("image/jpeg")
                || photo.getContentType().equals("image/png"))) {
            throw new UnsupportedMediaTypeException();

        }
        try {
            ApartmentEntity apartmentEntity = apartmentRepository.findById(apartmentId)
                    .orElseThrow(ApartmentNotFoundException::new);
            String id = photoRepository.savePhoto(photo);
            ApartmentPhotoEntity apartmentPhotoEntity = ApartmentPhotoEntity.builder()
                    .apartment(apartmentEntity)
                    .photoId(id)
                    .build();
            apartmentPhotoRepository.save(apartmentPhotoEntity);
            return id;
        } catch (IOException e) {
            throw new PhotoUploadException();
        }
    }

    @Override
    public void delete(String photoId, UUID apartmentId) {
        try {
            ApartmentPhotoEntity apartmentPhotoEntity = apartmentPhotoRepository.findByPhotoId(photoId)
                    .orElseThrow(PhotoNotFoundException::new);
            photoRepository.findById(photoId).orElseThrow(PhotoNotFoundException::new);
            if (apartmentPhotoEntity.getApartment().getId().equals(apartmentId)) {
                apartmentPhotoRepository.delete(apartmentPhotoEntity);
                photoRepository.delete(photoId);
            } else throw new ApartmentPhotoNotFoundException();
        } catch (IOException e) {
            throw new PhotoNotFoundException();
        }
    }

    @Override
    public void deleteAll(UUID apartmentId) {
        apartmentPhotoRepository.findByApartment_Id(apartmentId)
                .forEach(entity -> {
                    photoRepository.delete(entity.getPhotoId());
                    apartmentPhotoRepository.delete(entity);
                });
    }

    @Override
    public List<String> getAll(UUID apartmentId) {
        List<String> photos = new ArrayList<>();
        apartmentPhotoRepository.findByApartment_Id(apartmentId)
                .forEach(entity -> {
                    photos.add(entity.getPhotoId());
                });
        return photos;
    }
}
