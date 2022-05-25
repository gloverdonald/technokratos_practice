package com.technokratos.service.impl;

import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import com.technokratos.exception.*;
import com.technokratos.mapper.AvailabilityMapper;
import com.technokratos.mapper.BookingMapper;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.AvailabilityEntity;
import com.technokratos.model.BookingEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ApartmentRepository;
import com.technokratos.repository.AvailabilityRepository;
import com.technokratos.repository.BookingRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    private final ApartmentRepository apartmentRepository;
    private final UserRepository userRepository;

    @Override
    public AvailabilityResponse saveAvailability(UUID apartmentId,
                                                 AvailabilityRequest availabilityRequest,
                                                 UserDetails userDetails) {
        if (availabilityRepository.isNotAvailable(
                apartmentId,
                availabilityRequest.getDateFrom(),
                availabilityRequest.getDateTo())) {
            throw new HaveAnotherAvailability();
        }
        ApartmentEntity apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        if (!isUserOwnerOrAdmin(apartment.getOwner().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        AvailabilityEntity availability = availabilityMapper.toEntity(availabilityRequest);
        availability.setApartment(apartment);
        return availabilityMapper.toResponse(availabilityRepository.save(availability));
    }

    @Override
    public List<AvailabilityResponse> getAllAvailabilities(UUID apartmentId) {
        return availabilityRepository.getAvailabilityByApartmentId(apartmentId)
                .stream().map(availabilityMapper::toResponse).toList();
    }

    @Override
    public void deleteAvailability(UUID availabilityId, UserDetails userDetails) {
        AvailabilityEntity availability = availabilityRepository
                .findById(availabilityId).orElseThrow(AvailabilityNotFoundException::new);
        if (!isUserOwnerOrAdmin(availability.getApartment().getOwner().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        availability.setDeleted(true);
        availabilityRepository.save(availability);
    }

    @Override
    public BookingResponse addBooking(BookingRequest bookingRequest, UserDetails userDetails) {
        ApartmentEntity apartment = apartmentRepository
                .findById(bookingRequest.getApartmentId()).orElseThrow(ApartmentNotFoundException::new);
        UserEntity customer = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(UserNotFoundException::new);
        AvailabilityEntity availability = availabilityRepository.findByApartment_IdAndDeletedIsFalseAndDateFromBeforeAndDateToAfter(
                bookingRequest.getApartmentId(),
                bookingRequest.getDateIn(),
                bookingRequest.getDateOut()
        ).orElseThrow(AvailabilityNotFoundException::new);
        BookingEntity booking = bookingMapper.toEntity(bookingRequest);
        booking.setCustomer(customer);
        booking.setApartment(apartment);
        if (availability.getDateFrom() != bookingRequest.getDateIn()) {
            AvailabilityEntity newAvailabilityEntity = AvailabilityEntity.builder()
                    .dateFrom(availability.getDateFrom())
                    .apartment(availability.getApartment())
                    .dateTo(bookingRequest.getDateIn())
                    .build();
            availabilityRepository.save(newAvailabilityEntity);
        }
        if (bookingRequest.getDateOut() != availability.getDateTo()) {
            AvailabilityEntity newAvailabilityEntity = AvailabilityEntity.builder()
                    .dateFrom(bookingRequest.getDateOut())
                    .apartment(availability.getApartment())
                    .dateTo(availability.getDateTo())
                    .build();
            availabilityRepository.save(newAvailabilityEntity);
        }
        availability.setDeleted(true);
        availabilityRepository.save(availability);
        return bookingMapper.toResponse(bookingRepository.save(booking));
    }

    private Boolean isUserOwnerOrAdmin(String ownerEmail, UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ADMIN"))
                || userDetails.getUsername().equals(ownerEmail);
    }
}
