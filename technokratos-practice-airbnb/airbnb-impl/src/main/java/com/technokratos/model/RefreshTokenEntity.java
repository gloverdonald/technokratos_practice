package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "refresh_token")
public class RefreshTokenEntity extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(nullable = false, name = "expiry_date")
    private Instant expiryDate;
}
