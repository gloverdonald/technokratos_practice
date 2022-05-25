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
public class ChatRoomMemberRequest {

    private UUID memberId;

    private UUID chatRoomId;
}