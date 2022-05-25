package com.technokratos.api;

import com.technokratos.dto.request.ChatRoomMemberRequest;
import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.request.MessageRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.dto.response.MessageResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/chat")
public interface ChatApi<PRINCIPAL> {
    @ApiOperation(value = "Получение сообщения", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сообщение",
                    response = MessageResponse.class)})
    @GetMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse getMessageById(@ApiParam(value = "Идентификатор сообщения") @PathVariable("id") UUID id,
                                   @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Создание сообщения", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Сообщение",
                    response = MessageResponse.class)})
    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    MessageResponse createMessage(@ApiParam(value = "Сообщение") @RequestBody MessageRequest message);

    @ApiOperation(value = "Обновление сообщения", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Сообщение",
                    response = MessageResponse.class)})
    @PutMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse updateMessage(@ApiParam(value = "Идентификатор сообщения") @PathVariable("id") UUID id,
                                  @ApiParam(value = "Обновленное сообщение") @RequestBody MessageRequest message,
                                  @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Удаление сообщения")
    @DeleteMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteMessage(@ApiParam(value = "Идентификатор сообщения") @PathVariable("id") UUID id,
                       @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Получение диалога", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Диалог",
                    response = ChatRoomResponse.class)})
    @GetMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse getChatRoomById(@ApiParam(value = "Идентификатор диалога") @PathVariable("id") UUID id,
                                     @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Создание диалога", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Диалог",
                    response = ChatRoomResponse.class)})
    @PostMapping("/chat-room")
    @ResponseStatus(HttpStatus.CREATED)
    ChatRoomResponse createChatRoom(@ApiParam(value = "Данные для диалога") @RequestBody ChatRoomRequest room);

    @ApiOperation(value = "Обновление диалога", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Диалог",
                    response = ChatRoomResponse.class)})
    @PutMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse updateChatRoom(@ApiParam(value = "Идентификатор диалога") @PathVariable("id") UUID id,
                                    @ApiParam(value = "Данные для обновления диалога") @RequestBody ChatRoomRequest room,
                                    @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Удаление диалога")
    @DeleteMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteChatRoom(@ApiParam(value = "Идентификатор диалога") @PathVariable("id") UUID id,
                        @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Добавление участника диалога", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Диалог",
                    response = ChatRoomResponse.class)})
    @PostMapping("/chat-room/add-member")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse addChatRoomMember(@ApiParam(value = "Данные участника диалога")
                                       @RequestBody ChatRoomMemberRequest chatRoomMemberRequest);
}