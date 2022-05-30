package com.technokratos.service.impl;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.exception.AccessDeniedException;
import com.technokratos.exception.AddressNotFoundException;
import com.technokratos.exception.ApartmentNotFoundException;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.ApartmentMapper;
import com.technokratos.model.ApartmentAddressEntity;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.ApartmentInfoEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.AddressRepository;
import com.technokratos.repository.ApartmentInfoRepository;
import com.technokratos.repository.ApartmentRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    @Override
    public ApartmentResponse save(ApartmentRequest apartmentRequest) {
        ApartmentEntity apartmentEntity = apartmentMapper.toEntity(apartmentRequest);
        ApartmentAddressEntity address = addressRepository.findById(apartmentRequest.getAddressId()).orElseThrow(AddressNotFoundException::new);
        UserEntity owner = userRepository.findById(apartmentRequest.getOwnerId()).orElseThrow(UserNotFoundException::new);
        apartmentEntity.setAddress(address);
        apartmentEntity.setOwner(owner);
        return apartmentMapper.toResponse(apartmentRepository.save(apartmentEntity));
    }

    @Override
    public ApartmentResponse get(UUID id) {
        return apartmentMapper.toResponse(apartmentRepository.findById(id).orElseThrow(ApartmentNotFoundException::new));
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
        apartmentMapper.update(apartment, apartmentRequest);
        return apartmentMapper.toResponse(apartmentRepository.save(apartment));
    }

    @Override
    public List<ApartmentResponse> getAll(Specification<ApartmentEntity> specification) {
        return apartmentRepository.findAll(specification).stream().map(apartmentMapper::toResponse).toList();
    }

    private Boolean isUserOwnerOrAdmin(String ownerEmail, UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ADMIN"))
                || userDetails.getUsername().equals(ownerEmail);
    }
}