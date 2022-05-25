package com.technokratos.handler;

import com.technokratos.exception.HttpServiceException;
import com.technokratos.exception.dto.ServiceErrorDto;
import com.technokratos.exception.dto.ValidationErrorDto;
import com.technokratos.exception.dto.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpServiceException.class)
    public ResponseEntity<ServiceErrorDto> handleException(HttpServiceException exception) {
        return ResponseEntity.status(exception.getHttpStatus())
                .body(ServiceErrorDto.builder()
                        .message(exception.getMessage())
                        .exception(exception.getClass().getSimpleName())
                        .build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handleException(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(fieldError.getDefaultMessage())
                    .object(fieldError.getObjectName())
                    .field(fieldError.getField())
                    .build();
            errors.add(errorDto);
        });
        exception.getBindingResult().getGlobalErrors().forEach(objectError -> {
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .message(objectError.getDefaultMessage())
                    .object(objectError.getObjectName())
                    .build();
            errors.add(errorDto);
        });
        return ValidationExceptionResponse.builder()
                .errors(errors)
                .build();
    }
}