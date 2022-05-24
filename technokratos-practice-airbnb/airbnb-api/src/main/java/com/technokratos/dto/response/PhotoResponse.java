package com.technokratos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoResponse {
    private String id;

    private String name;

    private String type;

    private String size;

    private byte[] photo;
}
