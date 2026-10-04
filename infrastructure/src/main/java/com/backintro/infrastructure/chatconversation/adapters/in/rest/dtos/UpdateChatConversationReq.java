package com.backintro.infrastructure.chatconversation.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatConversationReq(UUID conversationStatusId, UUID priorityId, LocalDateTime lastMessageAt, boolean closed, LocalDateTime closedAt, UUID closedBy) {
}
