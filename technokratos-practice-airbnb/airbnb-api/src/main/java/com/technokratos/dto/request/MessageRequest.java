package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Сообщение диалога")
public class MessageRequest {

    @ApiModelProperty(value = "Текст")
    @NotBlank(message = "Текст сообщения не может быть пустым")
    @Size(min = 1, max = 255, message = "минимальный размер сообщения {min}, максимальный - {max}")
    private String text;

    @ApiModelProperty(value = "Идентификатор участника", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    @NotNull
    private UUID authorId;

    @ApiModelProperty(value = "Идентификатор диалога", example = "c21239e6-6e31-4dc0-894a-64e55be69a41")
    @NotNull
    private UUID chatRoomId;
}
