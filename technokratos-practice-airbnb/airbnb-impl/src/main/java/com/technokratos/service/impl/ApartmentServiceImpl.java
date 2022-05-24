package com.technokratos.service.impl;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.ApartmentSearchRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.exception.*;
import com.technokratos.mapper.ApartmentMapper;
import com.technokratos.model.ApartmentAddressEntity;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.ApartmentInfoEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.*;
import com.technokratos.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentInfoRepository apartmentInfoRepository;
    private final BookingRepository bookingRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    @Override
    public ApartmentResponse save(ApartmentRequest apartmentRequest) {
        ApartmentEntity apartmentEntity = apartmentRepository.save(apartmentMapper.toEntity(apartmentRequest));
        UserEntity owner = userRepository.findById(apartmentRequest.getOwnerId()).orElseThrow(UserNotFoundException::new);
        if (apartmentRequest.getInfoId() != null) {
            Optional<ApartmentInfoEntity> apartmentInfo = apartmentInfoRepository.findById(apartmentRequest.getInfoId());
            apartmentInfo.ifPresent(apartmentEntity::setInfo);
        }
        if (apartmentRequest.getAddressId() != null) {
            Optional<ApartmentAddressEntity> apartmentAddress = addressRepository.findById(apartmentRequest.getAddressId());
            apartmentAddress.ifPresent(apartmentEntity::setAddress);
        }
        apartmentEntity.setOwner(owner);
        ApartmentEntity apartment = apartmentRepository.save(apartmentEntity);
        return apartmentMapper.toResponse(apartment);
    }

    @Override
    public ApartmentResponse get(UUID id) {
        return apartmentMapper.toResponse(apartmentRepository.findById(id).orElseThrow(ApartmentNotFoundException::new));
    }

    @Override
    public Boolean isAvailable(ApartmentSearchRequest searchDto) {
        return bookingRepository.isAvailable(searchDto.getId(), searchDto.getDateStart(), searchDto.getDateEnd());
    }

    @Override
    public void delete(UUID id, UserDetails userDetails) {
        ApartmentEntity apartment = apartmentRepository.findById(id).orElseThrow(ApartmentNotFoundException::new);
        if (!isUserOwnerOrAdmin(apartment.getOwner().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        apartment.setDeleted(true);
    }

    @Override
    public ApartmentResponse update(UUID id, ApartmentRequest apartmentRequest, UserDetails userDetails) {
        ApartmentEntity apartment = apartmentRepository.findById(id).orElseThrow(ApartmentNotFoundException::new);
        if (!isUserOwnerOrAdmin(apartment.getOwner().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        if (apartmentRequest.getDescriptionLong() != null) {
            apartment.setDescriptionLong(apartmentRequest.getDescriptionLong());
        }
        if (apartmentRequest.getDescriptionShort() != null) {
            apartment.setDescriptionShort(apartmentRequest.getDescriptionShort());
        }
        if (apartmentRequest.getPrice() != null) {
            apartment.setPrice(apartmentRequest.getPrice());
        }
        if (apartmentRequest.getInfoId() != null) {
            apartment.setInfo(apartmentInfoRepository.findById(apartmentRequest.getInfoId()).orElseThrow(ApartmentInfoNotFoundException::new));
        }
        if (apartmentRequest.getAddressId() != null) {
            apartment.setAddress(addressRepository.findById(apartmentRequest.getAddressId()).orElseThrow(AddressNotFoundException::new));
        }
        return apartmentMapper.toResponse(apartmentRepository.save(apartment));
    }

    private Boolean isUserOwnerOrAdmin(String ownerEmail, UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ADMIN"))
                || userDetails.getUsername().equals(ownerEmail);
    }
}