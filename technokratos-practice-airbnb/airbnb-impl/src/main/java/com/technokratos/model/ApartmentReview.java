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
public class ApartmentReview extends AbstractEntity {
    private Integer rating;
    private String comment;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;
}
