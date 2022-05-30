package com.technokratos.repository;

import com.technokratos.model.ApartmentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApartmentInfoRepository extends JpaRepository<ApartmentInfoEntity, UUID> {

}