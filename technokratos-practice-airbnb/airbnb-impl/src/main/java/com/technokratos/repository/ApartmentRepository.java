package com.technokratos.repository;

import com.technokratos.model.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApartmentRepository extends JpaRepository<ApartmentEntity, UUID> {
}
