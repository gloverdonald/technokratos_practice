package com.technokratos.mapper;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.model.ApartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = UserMapper.class)
public interface ApartmentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "info", ignore = true)
    @Mapping(target = "availability", ignore = true)
    ApartmentEntity toEntity(ApartmentRequest apartmentRequest);

    ApartmentResponse toResponse(ApartmentEntity apartmentEntity);

    void update(@MappingTarget ApartmentEntity entity, ApartmentRequest apartmentRequest);
}
