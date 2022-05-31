package com.technokratos.mapper;

import com.technokratos.dto.request.AddressRequest;
import com.technokratos.dto.response.AddressResponse;
import com.technokratos.model.ApartmentAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ApartmentAddressEntity toAddress(AddressRequest addressRequest);

    AddressResponse toResponse(ApartmentAddressEntity addressEntity);
}
