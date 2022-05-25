package com.technokratos.service.impl;

import com.technokratos.dto.request.ChatRoomMemberRequest;
import com.technokratos.dto.request.ChatRoomRequest;
import com.technokratos.dto.request.MessageRequest;
import com.technokratos.dto.response.ChatRoomResponse;
import com.technokratos.dto.response.MessageResponse;
import com.technokratos.exception.AccessDeniedException;
import com.technokratos.exception.ChatRoomNotFoundException;
import com.technokratos.exception.MessageFoundException;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.ChatRoomMapper;
import com.technokratos.mapper.MessageMapper;
import com.technokratos.model.ChatRoomEntity;
import com.technokratos.model.MessageEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.ChatRoomRepository;
import com.technokratos.repository.MessageRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.technokratos.dto.enums.Role.ADMIN;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRoomMapper chatRoomMapper;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public MessageResponse saveMessage(MessageRequest messageRequest) {
        UserEntity author = userRepository.findById(messageRequest.getAuthorId()).orElseThrow(UserNotFoundException::new);
        ChatRoomEntity chatRoom = chatRoomRepository.findById(messageRequest.getChatRoomId()).orElseThrow(ChatRoomNotFoundException::new);
        if (chatRoom.getMembers().stream().noneMatch(member -> member.getEmail().equals(author.getEmail()))) {
            throw new AccessDeniedException();
        }
        MessageEntity messageEntity = MessageEntity.builder()
                .chatRoom(chatRoom)
                .author(author)
                .text(messageRequest.getText())
                .build();
        return messageMapper.toResponse(messageRepository.save(messageEntity));
    }

    @Override
    public MessageResponse getMessageById(UUID id, UserDetails userDetails) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(MessageFoundException::new);
        if (isUserAuthorOrAdmin(messageEntity.getAuthor().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        return messageMapper.toResponse(messageEntity);
    }

    @Override
    public void deleteMessageById(UUID id, UserDetails userDetails) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(MessageFoundException::new);
        if (isUserAuthorOrAdmin(messageEntity.getAuthor().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        messageEntity.setDeleted(true);
    }

    @Override
    public MessageResponse updateMessage(UUID id, MessageRequest messageRequest, UserDetails userDetails) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(MessageFoundException::new);
        if (isUserAuthorOrAdmin(messageEntity.getAuthor().getEmail(), userDetails)) {
            throw new AccessDeniedException();
        }
        if (messageRequest.getText() != null) {
            messageEntity.setText(messageRequest.getText());
        }
        if (messageRequest.getAuthorId() != null) {
            UserEntity newAuthor = userRepository.findById(messageRequest.getAuthorId())
                    .orElseThrow(UserNotFoundException::new);
            messageEntity.setAuthor(newAuthor);
        }
        if (messageRequest.getChatRoomId() != null) {
            ChatRoomEntity nawChatRoom = chatRoomRepository.findById(messageRequest.getChatRoomId()).orElseThrow(ChatRoomNotFoundException::new);
            messageEntity.setChatRoom(nawChatRoom);
        }
        return messageMapper.toResponse(messageRepository.save(messageEntity));
    }

    @Override
    public ChatRoomResponse saveChatRoom(ChatRoomRequest chatRoomRequest) {
        return chatRoomMapper.toResponse(chatRoomRepository.save(chatRoomMapper.toEntity(chatRoomRequest)));
    }

    @Override
    public ChatRoomResponse getChatRoomById(UUID id, UserDetails userDetails) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(id).orElseThrow(ChatRoomNotFoundException::new);
        if (!isUserMemberOrAdmin(chatRoom.getMembers(), userDetails)) {
            throw new AccessDeniedException();
        }
        return chatRoomMapper.toResponse(chatRoom);
    }

    @Override
    public void deleteChatRoomById(UUID id, UserDetails userDetails) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(id).orElseThrow(ChatRoomNotFoundException::new);
        if (!isUserMemberOrAdmin(chatRoom.getMembers(), userDetails)) {
            throw new AccessDeniedException();
        }
        chatRoom.setDeleted(true);
    }

    @Override
    public ChatRoomResponse updateChatRoom(UUID id, ChatRoomRequest chatRoomRequest, UserDetails userDetails) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(id).orElseThrow(ChatRoomNotFoundException::new);
        if (!isUserMemberOrAdmin(chatRoom.getMembers(), userDetails)) {
            throw new AccessDeniedException();
        }
        if (chatRoomRequest.getName() != null) {
            chatRoom.setName(chatRoomRequest.getName());
        }
        return chatRoomMapper.toResponse(chatRoomRepository.save(chatRoom));
    }

    @Override
    public ChatRoomResponse addChatRoomMember(ChatRoomMemberRequest chatRoomMemberRequest) {
        ChatRoomEntity chatRoom = chatRoomRepository.findById(chatRoomMemberRequest.getChatRoomId())
                .orElseThrow(ChatRoomNotFoundException::new);
        UserEntity user = userRepository.findById(chatRoomMemberRequest.getMemberId())
                .orElseThrow(UserNotFoundException::new);
        chatRoom.getMembers().add(user);
        return chatRoomMapper.toResponse(chatRoomRepository.save(chatRoom));
    }

    private Boolean isUserMemberOrAdmin(List<UserEntity> members, UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ADMIN"))
                || members.stream().anyMatch(member -> member.getEmail().equals(userDetails.getUsername()));
    }

    private Boolean isUserAuthorOrAdmin(String ownerEmail, UserDetails userDetails) {
        return userDetails.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ADMIN"))
                || userDetails.getUsername().equals(ownerEmail);
    }
}