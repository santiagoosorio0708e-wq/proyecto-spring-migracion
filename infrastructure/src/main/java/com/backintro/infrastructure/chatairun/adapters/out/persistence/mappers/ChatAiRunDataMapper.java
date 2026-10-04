package com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers;

import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunEntity;

public class ChatAiRunDataMapper {
    public ChatAiRunEntity toJpa(ChatAiRun aggregate) {
        if (aggregate == null) return null;
        return new ChatAiRunEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.messageId(), aggregate.modelId(), aggregate.aiRunStatusId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ChatAiRun toDomain(ChatAiRunEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiRun.restore(new ChatAiRunId(entityObj.getId()), entityObj.getConversationId(), entityObj.getMessageId(), entityObj.getModelId(), entityObj.getAiRunStatusId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
