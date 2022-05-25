package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Диалог")
public class ChatRoomResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Название")
    private String name;

    @ApiModelProperty(value = "Члены диалога")
    private List<UserResponse> members;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;
}