package com.technokratos.controller;

import com.technokratos.api.ApartmentApi;
import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.service.ApartmentPhotoService;
import com.technokratos.service.ApartmentService;
import com.technokratos.service.BookingService;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApartmentController implements ApartmentApi<UserDetails, ApartmentEntity> {
    private final ApartmentPhotoService apartmentPhotoService;
    private final ApartmentService apartmentService;
    private final BookingService bookingService;

    @Override
    public ApartmentResponse create(ApartmentRequest apartmentRequest, UserDetails userDetails) {
        return apartmentService.save(apartmentRequest, userDetails);
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
    public BookingResponse addBooking(UUID apartmentId, BookingRequest bookingRequest, UserDetails userDetails) {
        return bookingService.addBooking(apartmentId, bookingRequest, userDetails);
    }

    public List<ApartmentResponse> getAllApartments(
            @Join(path = "address", alias = "a")
            @Join(path = "info", alias = "i")
            @And({
                    @Spec(path = "i.parking", spec = Equal.class, params = "parking"),
                    @Spec(path = "i.pool", spec = Equal.class, params = "pool"),
                    @Spec(path = "i.microwave", spec = Equal.class, params = "microwave"),
                    @Spec(path = "i.iron", spec = Equal.class, params = "iron"),
                    @Spec(path = "i.refrigerator", spec = Equal.class, params = "refrigerator"),
                    @Spec(path = "i.conditioner", spec = Equal.class, params = "conditioner"),
                    @Spec(path = "i.garage", spec = Equal.class, params = "garage"),
                    @Spec(path = "i.heat", spec = Equal.class, params = "heat"),
                    @Spec(path = "i.washingMachine", spec = Equal.class, params = "washingMachine"),
                    @Spec(path = "a.country", spec = Like.class, params = "country"),
                    @Spec(path = "a.region", spec = Like.class, params = "region"),
                    @Spec(path = "a.city", spec = Like.class, params = "city"),
                    @Spec(path = "a.street", spec = Like.class, params = "street")})
            Specification<ApartmentEntity> specification) {
        return apartmentService.getAll(specification);
    }
}