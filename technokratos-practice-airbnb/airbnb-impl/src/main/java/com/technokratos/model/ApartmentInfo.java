package com.technokratos.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "apartment_info")
public class ApartmentInfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
