package com.backintro.infrastructure.chatmessage.adapters.out.persistence.mappers;

import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageEntity;

public class ChatMessageDataMapper {
    public ChatMessageEntity toJpa(ChatMessage aggregate) {
        if (aggregate == null) return null;
        return new ChatMessageEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.messageTypeId(), aggregate.participantId(), aggregate.content(), aggregate.metadata(), aggregate.createdAt());
    }

    public ChatMessage toDomain(ChatMessageEntity entityObj) {
        if (entityObj == null) return null;
        return ChatMessage.restore(new ChatMessageId(entityObj.getId()), entityObj.getConversationId(), entityObj.getMessageTypeId(), entityObj.getParticipantId(), entityObj.getContent(), entityObj.getMetadata(), entityObj.getCreatedAt());
    }
}
