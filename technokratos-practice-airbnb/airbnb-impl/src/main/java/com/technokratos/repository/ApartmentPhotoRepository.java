package com.technokratos.repository;

import com.technokratos.model.ApartmentPhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApartmentPhotoRepository extends JpaRepository<ApartmentPhotoEntity, UUID> {
    Optional<ApartmentPhotoEntity> findByPhotoId(String photoId);

    List<ApartmentPhotoEntity> findByApartment_Id(UUID apartmentId);

}
