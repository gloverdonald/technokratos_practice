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
@Table(name = "apartment_review")
public class ApartmentReviewEntity extends AbstractEntity {
    private Integer rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentEntity apartment;

    @Builder.Default
    private Boolean deleted = false;
}
