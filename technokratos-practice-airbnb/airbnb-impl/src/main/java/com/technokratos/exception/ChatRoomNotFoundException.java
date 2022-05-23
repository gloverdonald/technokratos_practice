package com.technokratos.exception;

import static com.technokratos.exception.MessageConstants.CHAT_ROOM_NOT_FOUND;

public class ChatRoomNotFoundException  extends ModelNotFoundException {
    public ChatRoomNotFoundException() {
        super(CHAT_ROOM_NOT_FOUND);
    }
}