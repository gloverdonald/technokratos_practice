package com.technokratos.controller;

import com.technokratos.api.ApartmentApi;
import com.technokratos.service.ApartmentPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApartmentController implements ApartmentApi {

    private final ApartmentPhotoService apartmentPhotoService;

    @Override
    public String uploadPhoto(MultipartFile photo, UUID apartmentId) {
        return apartmentPhotoService.upload(photo, apartmentId);
    }

    @Override
    public List<String> allPhotos(UUID apartmentId) {
        return apartmentPhotoService.getAll(apartmentId);
    }

    @Override
    public void deletePhoto(UUID apartmentId, String photoId) {
        apartmentPhotoService.delete(photoId, apartmentId);
    }

    @Override
    public void deletePhotos(UUID apartmentId) {
        apartmentPhotoService.deleteAll(apartmentId);
    }
}
