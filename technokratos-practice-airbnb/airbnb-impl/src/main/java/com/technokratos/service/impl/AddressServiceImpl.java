package com.technokratos.service.impl;

import com.technokratos.dto.request.AddressRequest;
import com.technokratos.dto.response.AddressResponse;
import com.technokratos.exception.AddressNotFoundException;
import com.technokratos.exception.DaDataAddressNotFoundException;
import com.technokratos.mapper.AddressMapper;
import com.technokratos.model.ApartmentAddressEntity;
import com.technokratos.repository.AddressRepository;
import com.technokratos.service.AddressService;
import com.technokratos.util.dadata.DaDataUtil;
import com.technokratos.util.dadata.model.DaDataAddressEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final DaDataUtil daDataUtil;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse create(AddressRequest addressRequest) {
        return addressMapper.toResponse(addressRepository.save(addressMapper.toAddress(addressRequest)));
    }

    @Override
    public AddressResponse create(String address) {
        DaDataAddressEntity dadataAddress = daDataUtil.cleanAddress(address);
        if (dadataAddress.getResult() == null) {
            throw new DaDataAddressNotFoundException();
        }
        ApartmentAddressEntity apartmentAddress = ApartmentAddressEntity.builder()
                .country(dadataAddress.getCountry())
                .region(dadataAddress.getRegion())
                .city(dadataAddress.getCity())
                .street(dadataAddress.getStreet())
                .houseNumber(dadataAddress.getHouse())
                .flatNumber(dadataAddress.getFlat())
                .postalCode(dadataAddress.getPostalCode())
                .build();
        return addressMapper.toResponse(addressRepository.save(apartmentAddress));
    }

    @Override
    public AddressResponse get(UUID id) {
        return addressMapper.toResponse(addressRepository.findById(id).orElseThrow(AddressNotFoundException::new));
    }
}
