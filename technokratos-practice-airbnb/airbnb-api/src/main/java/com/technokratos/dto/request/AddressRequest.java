package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {

    @NotBlank(message = "Адрес должен иметь название страны")
    @Size(min = 2, max = 50, message = "минимальный размер названия страны - {min}, максимальный - {max}")
    private String country;

    @NotBlank(message = "Адрес должен иметь название региона")
    @Size(min = 2, max = 50, message = "минимальный размер названия региона - {min}, максимальный - {max}")
    private String region;

    @NotBlank(message = "Адрес должен иметь название населенного пункта")
    @Size(min = 2, max = 50, message = "минимальный размер названия населенного пункта - {min}, максимальный - {max}")
    private String city;

    @NotBlank(message = "Адрес должен иметь название улицы")
    @Size(min = 2, max = 50, message = "минимальный размер названия улицы - {min}, максимальный - {max}")
    private String street;

    @NotBlank(message = "Адрес должен иметь номер дома")
    @Size(min = 1, max = 5, message = "минимальный размер номера дома - {min}, максимальный - {max}")
    private String houseNumber;

    private String flatNumber;

    private String postalCode;
}