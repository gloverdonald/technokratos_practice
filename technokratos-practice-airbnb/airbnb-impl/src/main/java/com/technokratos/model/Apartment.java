package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
public class Apartment extends AbstractEntity {
    Integer price;

    @Column(name = "description_long")
    String descriptionLong;

    @Column(name = "description_short")
    String descriptionShort;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Client owner;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    @ToString.Exclude
    List<Booking> bookings;

    @OneToOne(mappedBy = "apartment")
    ApartmentAddress address;

    @OneToOne(mappedBy = "apartment")
    ApartmentReview review;

    @OneToOne(mappedBy = "apartment")
    ApartmentInfo info;

    @OneToOne(mappedBy = "apartment")
    Availability availability;
}
