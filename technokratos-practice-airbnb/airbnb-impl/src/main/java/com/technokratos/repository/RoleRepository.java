package com.technokratos.repository;

import com.technokratos.dto.enums.Role;
import com.technokratos.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    Optional<RoleEntity> findByRole(Role role);
}

