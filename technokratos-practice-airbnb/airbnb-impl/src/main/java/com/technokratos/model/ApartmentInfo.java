package com.technokratos.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "apartment_info")
public class ApartmentInfo extends AbstractEntity {
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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "apartment_id", referencedColumnName = "uuid")
    private Apartment apartment;
}
