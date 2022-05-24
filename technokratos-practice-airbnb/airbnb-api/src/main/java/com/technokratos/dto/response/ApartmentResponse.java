package com.technokratos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentResponse {
    private Integer price;

    private String descriptionLong;

    private String descriptionShort;

    private UserResponse owner;

    private Boolean deleted;
}
