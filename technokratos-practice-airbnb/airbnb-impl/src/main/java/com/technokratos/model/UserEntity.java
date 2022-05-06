package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
@Table(name = "account")
public class UserEntity extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @Column(name = "birth_date")
    private Date birthDate;

    @Builder.Default
    private Boolean verified = false;

    @ToString.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<BookingEntity> bookings;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<ApartmentEntity> apartments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles;

    @Builder.Default
    private Boolean deleted = false;
}
