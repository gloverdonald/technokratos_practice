package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "confirmation_token")
public class ConfirmationTokenEntity extends AbstractEntity {

    @Column(name = "token")
    private String token;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private UserEntity user;
}
