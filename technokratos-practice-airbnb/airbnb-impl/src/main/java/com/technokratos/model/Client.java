package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
public class Client extends AbstractEntity {
    private String email;
    private String password;
    @ColumnDefault("false")
    private Boolean verified = false;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Booking> bookings;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Apartment> apartments;
}
