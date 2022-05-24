package com.technokratos.service;

import com.technokratos.dto.request.ChatRoomMemberRequest;
import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.request.MessageRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.dto.response.MessageResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface ChatService {
    MessageResponse saveMessage(MessageRequest messageRequest);

    MessageResponse getMessageById(UUID id, UserDetails userDetails);

    void deleteMessageById(UUID id, UserDetails userDetails);

    MessageResponse updateMessage(UUID id, MessageRequest messageRequest, UserDetails userDetails);

    ChatRoomResponse saveChatRoom(ChatRoomRequest chatRoomRequest);

    ChatRoomResponse getChatRoomById(UUID id, UserDetails userDetails);

    void deleteChatRoomById(UUID id, UserDetails userDetails);

    ChatRoomResponse updateChatRoom(UUID id, ChatRoomRequest chatRoomRequest, UserDetails userDetails);

    ChatRoomResponse addChatRoomMember(ChatRoomMemberRequest chatRoomMemberRequest);
}