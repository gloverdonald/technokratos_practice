package com.technokratos.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Apartment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

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

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
