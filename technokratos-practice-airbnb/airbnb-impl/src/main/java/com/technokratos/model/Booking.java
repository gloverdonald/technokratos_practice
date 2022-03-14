package com.technokratos.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Booking {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    Apartment apartment;

    @Column(name = "date_in")
    Date dateIn;

    @Column(name = "date_out")
    Date dateOut;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Client client;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
