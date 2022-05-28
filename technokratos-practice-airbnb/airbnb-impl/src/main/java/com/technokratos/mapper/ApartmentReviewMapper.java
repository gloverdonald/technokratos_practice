package com.technokratos.mapper;

import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import com.technokratos.model.ApartmentReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = ApartmentMapper.class)
public interface ApartmentReviewMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ApartmentReviewEntity toEntity(ApartmentReviewRequest apartmentReviewRequest);

    ApartmentReviewResponse toResponse(ApartmentReviewEntity apartmentReviewEntity);

    void update(@MappingTarget ApartmentReviewEntity entity, ApartmentReviewRequest apartmentReviewRequest);
}