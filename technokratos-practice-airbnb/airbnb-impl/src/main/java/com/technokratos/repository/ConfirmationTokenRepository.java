package com.technokratos.repository;

import com.technokratos.model.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, UUID> {

    Optional<ConfirmationTokenEntity> findByToken(String token);

}
