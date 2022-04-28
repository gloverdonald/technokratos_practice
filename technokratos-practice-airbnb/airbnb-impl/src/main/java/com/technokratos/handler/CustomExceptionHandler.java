package com.technokratos.handler;

import com.technokratos.exception.HttpServiceException;
import com.technokratos.exception.dto.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpServiceException.class)
    public ResponseEntity<ValidationErrorDto> handleException(HttpServiceException exception) {
        return ResponseEntity.status(exception.getHttpStatus())
                .body(ValidationErrorDto.builder()
                        .message(exception.getMessage())
                        .exception(exception.getClass().getSimpleName())
                        .build());
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ValidationErrorDto> onSignatureException(SignatureException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ValidationErrorDto.builder()
                        .message(exception.getMessage())
                        .exception(exception.getClass().getSimpleName())
                        .build());
    }



    @ExceptionHandler(io.jsonwebtoken.SignatureException.class)
    public ResponseEntity<ValidationErrorDto> onSignatureException2(SignatureException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ValidationErrorDto.builder()
                        .message(exception.getMessage())
                        .exception(exception.getClass().getSimpleName())
                        .build());
    }


}
