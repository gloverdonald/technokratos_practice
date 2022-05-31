package com.technokratos.service.impl;

import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.ApartmentInfoResponse;
import com.technokratos.exception.ApartmentInfoNotFoundException;
import com.technokratos.exception.ApartmentNotFoundException;
import com.technokratos.mapper.ApartmentInfoMapper;
import com.technokratos.model.ApartmentEntity;
import com.technokratos.model.ApartmentInfoEntity;
import com.technokratos.repository.ApartmentInfoRepository;
import com.technokratos.repository.ApartmentRepository;
import com.technokratos.service.ApartmentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApartmentInfoServiceImpl implements ApartmentInfoService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentInfoRepository apartmentInfoRepository;
    private final ApartmentInfoMapper apartmentInfoMapper;

    @Override
    public ApartmentInfoResponse create(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest) {
        ApartmentEntity apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        ApartmentInfoEntity apartmentInfo = apartmentInfoMapper.toEntity(apartmentInfoRequest);
        apartment.setInfo(apartmentInfo);
        return apartmentInfoMapper.toResponse(apartmentRepository.save(apartment).getInfo());
    }

    @Override
    public ApartmentInfoResponse get(UUID apartmentId) {
        ApartmentEntity apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        ApartmentInfoEntity apartmentInfo = Optional.of(apartment.getInfo()).orElseThrow(ApartmentInfoNotFoundException::new);
        return apartmentInfoMapper.toResponse(apartmentInfo);
    }

    @Override
    public ApartmentInfoResponse update(UUID apartmentId, ApartmentInfoRequest apartmentInfoRequest) {
        ApartmentEntity apartment = apartmentRepository.findById(apartmentId).orElseThrow(ApartmentNotFoundException::new);
        ApartmentInfoEntity apartmentInfo = Optional.of(apartment.getInfo()).orElseThrow(ApartmentInfoNotFoundException::new);
        apartmentInfoMapper.update(apartmentInfo, apartmentInfoRequest);
        return apartmentInfoMapper.toResponse(apartmentInfoRepository.save(apartmentInfo));
    }
}
