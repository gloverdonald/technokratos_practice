package com.technokratos.controller;

import com.technokratos.api.ApartmentApi;
import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import com.technokratos.service.ApartmentPhotoService;
import com.technokratos.service.ApartmentService;
import com.technokratos.service.BookingService;
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
    private final BookingService bookingService;

    @Override
    public ApartmentResponse create(ApartmentRequest apartmentRequest) {
        return apartmentService.save(apartmentRequest);
    }

    @Override
    public ApartmentResponse get(UUID id) {
        return apartmentService.get(id);
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

    @Override
    public AvailabilityResponse createAvailability(UUID apartmentId, AvailabilityRequest availabilityRequest, UserDetails userDetails) {
        return bookingService.saveAvailability(apartmentId, availabilityRequest, userDetails);
    }

    @Override
    public List<AvailabilityResponse> getAllAvailabilities(UUID apartmentId) {
        return bookingService.getAllAvailabilities(apartmentId);
    }

    @Override
    public void deleteAvailability(UUID availabilityId, UserDetails userDetails) {
        bookingService.deleteAvailability(availabilityId, userDetails);
    }

    @Override
    public BookingResponse addBooking(BookingRequest bookingRequest, UserDetails userDetails) {
        return bookingService.addBooking(bookingRequest, userDetails);
    }
}
