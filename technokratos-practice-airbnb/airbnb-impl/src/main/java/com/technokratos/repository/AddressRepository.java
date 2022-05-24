package com.technokratos.repository;

import com.technokratos.model.ApartmentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<ApartmentAddressEntity, UUID> {
}
