package com.technokratos.controller;

import com.technokratos.api.PhotoApi;
import com.technokratos.dto.response.PhotoResponse;
import com.technokratos.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.bson.internal.Base64;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class PhotoController implements PhotoApi {

    private final PhotoService photoService;

    @Override
    public PhotoResponse downloadPhoto(String id) {
        return photoService.download(id);
    }

    @Override
    public ResponseEntity<byte[]> showPhoto(String id) {
        PhotoResponse photo = photoService.download(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getName() + "\"")
                .body(photo.getPhoto());
    }
}
