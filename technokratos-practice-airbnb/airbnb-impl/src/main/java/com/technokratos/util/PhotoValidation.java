package com.technokratos.util;

import com.technokratos.exception.PhotoIsEmptyException;
import com.technokratos.exception.UnsupportedMediaTypeException;
import org.springframework.web.multipart.MultipartFile;

public class PhotoValidation {
    public static void validatePhoto(MultipartFile photo) {
        if (photo.isEmpty() || photo.getSize() == 0) {
            throw new PhotoIsEmptyException();
        }
        if (!(photo.getContentType().equals("image/jpeg")
                || photo.getContentType().equals("image/png"))) {
            throw new UnsupportedMediaTypeException();
        }
    }
}
