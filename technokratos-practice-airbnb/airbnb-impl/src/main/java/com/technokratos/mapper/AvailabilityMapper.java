package com.technokratos.mapper;

import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.model.AvailabilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = ApartmentMapper.class)
public interface AvailabilityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    AvailabilityEntity toEntity(AvailabilityRequest availabilityRequest);

    AvailabilityResponse toResponse(AvailabilityEntity availabilityEntity);
}
