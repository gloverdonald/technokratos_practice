package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private String text;

    private UUID authorId;

    private UUID chatRoomId;
}
