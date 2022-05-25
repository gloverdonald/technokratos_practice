package com.technokratos.api;

import com.technokratos.dto.request.ChatRoomMemberRequest;
import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.request.MessageRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/chat")
public interface ChatApi<PRINCIPAL> {
    @GetMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse getMessageById(@PathVariable("id") UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    MessageResponse createMessage(@Valid @RequestBody MessageRequest message);

    @PutMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    MessageResponse updateMessage(@PathVariable("id") UUID id, @Valid @RequestBody MessageRequest message,
                                  @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @DeleteMapping("/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteMessage(@PathVariable("id") UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @GetMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse getChatRoomById(@PathVariable("id") UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/chat-room")
    @ResponseStatus(HttpStatus.CREATED)
    ChatRoomResponse createChatRoom(@RequestBody ChatRoomRequest room);

    @PutMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse updateChatRoom(@PathVariable("id") UUID id, @RequestBody ChatRoomRequest room,
                                    @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @DeleteMapping("/chat-room/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteChatRoom(@PathVariable("id") UUID id, @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @PostMapping("/chat-room/add-member")
    @ResponseStatus(HttpStatus.OK)
    ChatRoomResponse addChatRoomMember(@RequestBody ChatRoomMemberRequest chatRoomMemberRequest);
}