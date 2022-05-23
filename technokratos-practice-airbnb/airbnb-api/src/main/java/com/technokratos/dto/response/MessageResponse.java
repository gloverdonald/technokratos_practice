package com.technokratos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private UUID id;

    private String text;

    private UserResponse author;

    private ChatRoomResponse chatRoom;

    private Instant createDate;

    private Instant updateDate;

    private Boolean deleted;
}
