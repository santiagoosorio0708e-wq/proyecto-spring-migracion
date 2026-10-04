package com.backintro.infrastructure.chatconversationaisetting.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatAiSettingsReq(UUID conversationId, boolean aiEnabled, UUID defaultModelId) {
}
