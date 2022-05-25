package com.technokratos.mapper;

import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.BookingResponse;
import com.technokratos.model.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = ApartmentMapper.class)
public interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "apartment", ignore = true)
    @Mapping(target = "customer", ignore = true)
    BookingEntity toEntity(BookingRequest bookingRequest);

    BookingResponse toResponse(BookingEntity bookingEntity);
}
