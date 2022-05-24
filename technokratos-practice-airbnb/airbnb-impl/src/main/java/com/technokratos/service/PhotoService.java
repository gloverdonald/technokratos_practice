package com.technokratos.service;

import com.technokratos.dto.response.PhotoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    String upload(MultipartFile photo);

    PhotoResponse download(String id);
}
