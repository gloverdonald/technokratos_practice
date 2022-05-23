package com.technokratos.api;

import com.technokratos.dto.response.PhotoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/photo")
public interface PhotoApi {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PhotoResponse downloadPhoto(@PathVariable("id") String id);

    @GetMapping(value = "/view/{id}")
    ResponseEntity<byte[]> showPhoto(@PathVariable("id") String id);
}
