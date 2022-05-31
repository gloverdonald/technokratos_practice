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
@Table(name = "apartment_info")
public class ApartmentInfoEntity extends AbstractEntity {
    private Boolean parking;

    private Boolean pool;

    private Boolean microwave;

    private Boolean iron;

    private Boolean refrigerator;

    private Boolean conditioner;

    private Boolean garage;

    private Boolean heat;

    @Column(name = "washing_machine")
    private Boolean washingMachine;

    @Builder.Default
    private Boolean deleted = false;
}
