package com.technokratos.mapper;

import com.technokratos.dto.response.PhotoResponse;
import com.technokratos.model.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PhotoMapper {

    PhotoResponse toResponse(PhotoEntity photo);
}
