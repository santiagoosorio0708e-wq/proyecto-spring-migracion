package com.backintro.infrastructure.chatescalation.adapters.out.persistence.mappers;

import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationEntity;

public class ChatEscalationDataMapper {
    public ChatEscalationEntity toJpa(ChatEscalation aggregate) {
        if (aggregate == null) return null;
        return new ChatEscalationEntity(aggregate.id().value(), aggregate.conversationId(), aggregate.statusId(), aggregate.fromAi(), aggregate.reason(), aggregate.createdAt());
    }

    public ChatEscalation toDomain(ChatEscalationEntity entityObj) {
        if (entityObj == null) return null;
        return ChatEscalation.restore(new ChatEscalationId(entityObj.getId()), entityObj.getConversationId(), entityObj.getStatusId(), entityObj.getFromAi(), entityObj.getReason(), entityObj.getCreatedAt());
    }
}
