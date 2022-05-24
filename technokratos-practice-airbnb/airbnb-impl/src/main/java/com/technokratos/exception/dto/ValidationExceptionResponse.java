package com.technokratos.exception.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationExceptionResponse {

    private List<ValidationErrorDto> errors;
}
