package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "apartment_photos")
public class ApartmentPhotoEntity extends AbstractEntity {

    @Column(name = "photo_id")
    String photoId;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartment;
}
