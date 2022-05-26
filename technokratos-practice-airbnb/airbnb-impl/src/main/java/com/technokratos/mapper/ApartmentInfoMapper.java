package com.technokratos.mapper;

import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.ApartmentInfoResponse;
import com.technokratos.model.ApartmentInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = ApartmentMapper.class)
public interface ApartmentInfoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ApartmentInfoEntity toEntity(ApartmentInfoRequest apartmentInfoRequest);

    ApartmentInfoResponse toResponse(ApartmentInfoEntity apartmentInfoEntity);
}
