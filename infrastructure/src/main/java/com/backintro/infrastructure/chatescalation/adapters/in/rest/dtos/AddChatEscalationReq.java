package com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos;

import java.util.UUID;

public record AddChatEscalationReq(UUID conversationId, UUID statusId, boolean fromAi, String reason) {
}
