package com.technokratos.controller;

import com.technokratos.api.ApartmentApi;
import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.ApartmentSearchRequest;
import com.technokratos.dto.response.AddressResponse;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.service.ApartmentPhotoService;
import com.technokratos.service.ApartmentService;
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
    private final ApartmentService apartmentService;

    @Override
    public ApartmentResponse create(ApartmentRequest apartmentRequest) {
        return apartmentService.save(apartmentRequest);
    }

    @Override
    public ApartmentResponse get(UUID id) {
        return apartmentService.get(id);
    }

    @Override
    public Boolean checkAvailability(ApartmentSearchRequest searchDto) {
        return apartmentService.isAvailable(searchDto);
    }

    @Override
    public void delete(UUID id, UserDetails userDetails) {
        apartmentService.delete(id, userDetails);
    }

    @Override
    public ApartmentResponse update(UUID id, ApartmentRequest apartmentRequest, UserDetails userDetails) {
        return apartmentService.update(id, apartmentRequest, userDetails);
    }


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
