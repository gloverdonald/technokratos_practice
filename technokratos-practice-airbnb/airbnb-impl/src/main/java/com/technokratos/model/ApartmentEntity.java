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
@Table(name = "apartment")
public class ApartmentEntity extends AbstractEntity {

    private Integer price;
    @Column(name = "description_long")
    private String descriptionLong;

    @Column(name = "description_short")
    private String descriptionShort;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<BookingEntity> bookings;

    @OneToOne(mappedBy = "apartment")
    private ApartmentAddressEntity address;

    @OneToOne(mappedBy = "apartment")
    private ApartmentReviewEntity review;

    @OneToOne(mappedBy = "apartment")
    private ApartmentInfoEntity info;

    @OneToOne(mappedBy = "apartment")
    private AvailabilityEntity availability;
}
