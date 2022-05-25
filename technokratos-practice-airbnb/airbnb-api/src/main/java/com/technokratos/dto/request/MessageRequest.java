package com.technokratos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    @NotBlank(message = "Текст сообщения не может быть пустым")
    @Size(min = 1, max = 255, message = "минимальный размер сообщения {min}, максимальный - {max}")
    private String text;

    private UUID authorId;

    private UUID chatRoomId;
}
