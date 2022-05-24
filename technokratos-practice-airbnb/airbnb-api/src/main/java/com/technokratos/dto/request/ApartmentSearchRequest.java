package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ApartmentSearchRequest {
    private Long id;

    private Date dateStart;

    private Date dateEnd;
}