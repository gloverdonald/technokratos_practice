package com.technokratos.api;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments")
public interface ApartmentApi<PRINCIPAL> {
<<<<<<< technokratos-practice-airbnb/airbnb-api/src/main/java/com/technokratos/api/ApartmentApi.java
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    ApartmentResponse create(@RequestBody ApartmentRequest apartmentRequest);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse get(@PathVariable UUID id);


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse update(@PathVariable UUID id, @RequestBody ApartmentRequest apartmentRequest, @AuthenticationPrincipal PRINCIPAL userPrincipal);
=======
>>>>>>> technokratos-practice-airbnb/airbnb-api/src/main/java/com/technokratos/api/ApartmentApi.java

    @PostMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    String uploadPhoto(@RequestParam("photo") MultipartFile photo,
                       @PathVariable("id") UUID apartmentId,
                       @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @GetMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    List<String> allPhotos(@PathVariable("id") UUID apartmentId);

    @DeleteMapping("/{id}/photo/{photoId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePhoto(@PathVariable("id") UUID apartmentId,
                     @PathVariable("photoId") String photoId,
                     @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @DeleteMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    void deletePhotos(@PathVariable("id") UUID apartmentId, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping(value = "/{id}/availability")
    @ResponseStatus(HttpStatus.CREATED)
    AvailabilityResponse createAvailability(@PathVariable("id") UUID apartmentId,
                                            @RequestBody AvailabilityRequest availabilityRequest,
                                            @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @GetMapping(value = "/{id}/availabilities")
    @ResponseStatus(HttpStatus.OK)
    List<AvailabilityResponse> getAllAvailabilities(@PathVariable("id") UUID apartmentId);

    @DeleteMapping(value = "/{id}/availability")
    @ResponseStatus(HttpStatus.OK)
    void deleteAvailability(@PathVariable("id") UUID availabilityId, @AuthenticationPrincipal PRINCIPAL userPrincipal);


    @PostMapping(value = "/booking")
    @ResponseStatus(HttpStatus.CREATED)
    BookingResponse addBooking(@RequestBody BookingRequest bookingRequest,
                               @AuthenticationPrincipal PRINCIPAL userPrincipal);
}
