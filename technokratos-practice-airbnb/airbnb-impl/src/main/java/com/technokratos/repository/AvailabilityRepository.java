package com.technokratos.repository;

import com.technokratos.model.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AvailabilityRepository extends JpaRepository<AvailabilityEntity, UUID> {
    @Query("select count(a) <> 0 from AvailabilityEntity a where ((:start >= a.dateFrom and :start <= a.dateTo) " +
            "or (:end >= a.dateFrom and :end <= a.dateTo)) and a.apartment.id = :id")
    Boolean isNotAvailable(@Param("id") UUID id, @Param("start") Date start, @Param("end") Date end);

    List<AvailabilityEntity> getAvailabilityByApartmentId(UUID id);

    //Optional<AvailabilityEntity> findByApartment_IdAndDeletedIsFalseAndDateFromBeforeAndDateToAfter(UUID apartment_id, Date dateFrom, Date dateTo);

    Optional<AvailabilityEntity> findByApartment_IdAndDeletedIsFalseAndDateFromLessThanEqualAndDateToGreaterThanEqual(UUID apartment_id, Date dateFrom, Date dateTo);

}
