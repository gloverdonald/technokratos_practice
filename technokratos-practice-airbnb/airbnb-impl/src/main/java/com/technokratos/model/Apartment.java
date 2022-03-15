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
    private Integer price;

    @Column(name = "description_long")
    private String descriptionLong;

    @Column(name = "description_short")
    private String descriptionShort;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Client owner;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Booking> bookings;

    @OneToOne(mappedBy = "apartment")
    private ApartmentAddress address;

    @OneToOne(mappedBy = "apartment")
    private ApartmentReview review;

    @OneToOne(mappedBy = "apartment")
    private ApartmentInfo info;

    @OneToOne(mappedBy = "apartment")
    private Availability availability;
}
