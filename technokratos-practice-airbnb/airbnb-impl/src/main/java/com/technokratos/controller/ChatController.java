package com.technokratos.controller;

import com.technokratos.api.ChatApi;
import com.technokratos.dto.request.ChatRoomMemberRequest;
import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.request.MessageRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.dto.response.MessageResponse;
import com.technokratos.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ChatController implements ChatApi<UserDetails> {
    private final ChatService chatService;

    @GetMapping("/test")
    public String getTest(@AuthenticationPrincipal UserDetails userDetails) {
        return "test";
    }

    @Override
    public MessageResponse getMessageById(UUID id, UserDetails userDetails) {
        return chatService.getMessageById(id, userDetails);
    }


    @Override
    public MessageResponse createMessage(MessageRequest messageRequest) {
        return chatService.saveMessage(messageRequest);
    }

    @Override
    public MessageResponse updateMessage(UUID id, MessageRequest messageRequest, UserDetails userDetails) {
        return chatService.updateMessage(id, messageRequest, userDetails);
    }

    @Override
    public void deleteMessage(UUID id, UserDetails userDetails) {
        chatService.deleteMessageById(id, userDetails);
    }

    @Override
    public ChatRoomResponse getChatRoomById(UUID id, UserDetails userDetails) {
        return chatService.getChatRoomById(id, userDetails);
    }

    @Override
    public ChatRoomResponse createChatRoom(ChatRoomRequest chatRoomRequest) {
        return chatService.saveChatRoom(chatRoomRequest);
    }

    @Override
    public ChatRoomResponse updateChatRoom(UUID id, ChatRoomRequest chatRoomRequest, UserDetails userDetails) {
        return chatService.updateChatRoom(id, chatRoomRequest, userDetails);
    }

    @Override
    public void deleteChatRoom(UUID id, UserDetails userDetails) {
        chatService.deleteChatRoomById(id, userDetails);
    }

    @Override
    public ChatRoomResponse addChatRoomMember(ChatRoomMemberRequest chatRoomMemberRequest) {
        return chatService.addChatRoomMember(chatRoomMemberRequest);
    }
}