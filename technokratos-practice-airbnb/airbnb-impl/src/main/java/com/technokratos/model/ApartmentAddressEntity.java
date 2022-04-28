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
@Table(name = "apartment_address")
public class ApartmentAddressEntity extends AbstractEntity {

    private String country;

    private String region;

    private String city;

    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private ApartmentEntity apartment;
}
