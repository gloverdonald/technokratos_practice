package com.technokratos.mapper;

import com.technokratos.dto.response.MessageResponse;
import com.technokratos.model.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {UserMapper.class, ChatRoomMapper.class})
public interface MessageMapper {
    MessageResponse toResponse(MessageEntity messageEntity);
}