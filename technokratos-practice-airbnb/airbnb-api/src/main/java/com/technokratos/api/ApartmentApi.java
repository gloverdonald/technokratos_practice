package com.technokratos.api;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.ApartmentSearchRequest;
import com.technokratos.dto.response.ApartmentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments")
public interface ApartmentApi<PRINCIPAL> {
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    ApartmentResponse create(@RequestBody ApartmentRequest apartmentRequest);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse get(@PathVariable UUID id);

    @PostMapping("/availability")
    @ResponseStatus(HttpStatus.OK)
    Boolean checkAvailability(@RequestBody ApartmentSearchRequest searchDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse update(@PathVariable UUID id, @RequestBody ApartmentRequest apartmentRequest, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    String uploadPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable("id") UUID apartmentId);

    @GetMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    List<String> allPhotos(@PathVariable("id") UUID apartmentId);

    @DeleteMapping("/{id}/photo/{photoId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePhoto(@PathVariable("id") UUID apartmentId, @PathVariable("photoId") String photoId);

    @DeleteMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    void deletePhotos(@PathVariable("id") UUID apartmentId);
}
