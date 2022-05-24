package com.technokratos.mapper;

import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.model.ChatRoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ChatRoomMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ChatRoomEntity toEntity(ChatRoomRequest chatRoomRequest);

    ChatRoomResponse toResponse(ChatRoomEntity chatRoomEntity);
}