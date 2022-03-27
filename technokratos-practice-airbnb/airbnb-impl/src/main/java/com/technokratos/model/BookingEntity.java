package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "booking")
public class BookingEntity extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartmentEntity;

    @Column(name = "date_in")
    private Date dateIn;

    @Column(name = "date_out")
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity user;
}
