package com.technokratos.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PhotoEntity {

    @Id
    private String id;

    private String name;

    private String type;

    private String size;

    private byte[] photo;

}
