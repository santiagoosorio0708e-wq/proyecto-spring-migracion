package com.backintro.infrastructure.chatmessage.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatMessageReq(UUID conversationId, UUID messageTypeId, UUID participantId, String content, String metadata) {
}
