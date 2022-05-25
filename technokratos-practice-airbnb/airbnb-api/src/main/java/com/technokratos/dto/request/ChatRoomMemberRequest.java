package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Участник диалога")
public class ChatRoomMemberRequest {

    @ApiModelProperty(value = "Идентификатор участника", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID memberId;

    @ApiModelProperty(value = "Идентификатор диалога", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    private UUID chatRoomId;
}