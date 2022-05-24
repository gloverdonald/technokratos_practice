package com.technokratos.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments")
public interface ApartmentApi<PRINCIPAL> {

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

}
