package com.technokratos.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments")
public interface ApartmentApi {

    @PostMapping("/apartment/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    String photoUpload(@RequestParam("photo") MultipartFile photo, @PathVariable("id") UUID apartmentId);

    @GetMapping("/apartment/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    List<String> allPhotos(@PathVariable("id") UUID apartmentId);

    @DeleteMapping("/apartment/{id}/photo/{photoId}")
    @ResponseStatus(HttpStatus.OK)
    void photoDelete(@PathVariable("id") UUID apartmentId, @PathVariable("photoId") String photoId);

    @DeleteMapping("/apartment/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    void photosDelete(@PathVariable("id") UUID apartmentId);
}
