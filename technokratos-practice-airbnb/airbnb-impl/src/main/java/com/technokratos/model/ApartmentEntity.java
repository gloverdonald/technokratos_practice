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

    @ToString.Exclude
    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    private List<BookingEntity> bookings;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private ApartmentAddressEntity address;

    @ToString.Exclude
    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    private List<ApartmentReviewEntity> reviews;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "info_id")
    private ApartmentInfoEntity info;

    @ToString.Exclude
    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    private List<AvailabilityEntity> availability;

    @ToString.Exclude
    @OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
    private List<ApartmentPhotoEntity> photos;

    @Builder.Default
    private Boolean deleted = false;
}
