package com.technokratos.controller;

import com.technokratos.api.ApartmentApi;
import com.technokratos.service.ApartmentPhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApartmentController implements ApartmentApi<UserDetails> {

    private final ApartmentPhotoService apartmentPhotoService;

    @Override
    public String uploadPhoto(MultipartFile photo, UUID apartmentId, UserDetails userPrincipal) {
        return apartmentPhotoService.upload(photo, apartmentId, userPrincipal);
    }

    @Override
    public List<String> allPhotos(UUID apartmentId) {
        return apartmentPhotoService.getAll(apartmentId);
    }

    @Override
    public void deletePhoto(UUID apartmentId, String photoId, UserDetails userPrincipal) {
        apartmentPhotoService.delete(photoId, apartmentId, userPrincipal);
    }

    @Override
    public void deletePhotos(UUID apartmentId, UserDetails userPrincipal) {
        apartmentPhotoService.deleteAll(apartmentId, userPrincipal);
    }
}
