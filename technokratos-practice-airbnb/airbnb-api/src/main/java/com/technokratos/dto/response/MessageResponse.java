package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Сообщение")
public class MessageResponse {

    @ApiModelProperty(value = "Идентификатор")
    private UUID id;

    @ApiModelProperty(value = "Текст")
    private String text;

    @ApiModelProperty(value = "Автор")
    private UserResponse author;

    @ApiModelProperty(value = "Диалог")
    private ChatRoomResponse chatRoom;

    @ApiModelProperty(value = "Дата создания")
    private Instant createDate;

    @ApiModelProperty(value = "Дата обновления")
    private Instant updateDate;

    @ApiModelProperty(value = "Удален")
    private Boolean deleted;
}