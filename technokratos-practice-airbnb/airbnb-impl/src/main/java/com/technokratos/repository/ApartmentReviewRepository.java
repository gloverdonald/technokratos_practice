package com.technokratos.repository;

import com.technokratos.model.ApartmentReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApartmentReviewRepository extends JpaRepository<ApartmentReviewEntity, UUID> {
    List<ApartmentReviewEntity> findByApartment_Id(UUID id);
}
