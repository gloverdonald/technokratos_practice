package com.technokratos.api;

import com.technokratos.dto.response.PhotoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/photo")
public interface PhotoApi {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PhotoResponse photoDownload(@PathVariable("id") String id);

    @GetMapping(value = "/view/{id}")
    ResponseEntity<byte[]> photoShow(@PathVariable("id") String id);
}
