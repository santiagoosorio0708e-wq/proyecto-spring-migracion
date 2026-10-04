package com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.mappers;

import com.backintro.domain.conversationsstatus.model.aggregate.ConversationStatus;
import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.entity.ConversationStatusEntity;

public class ConversationStatusDataMapper {
    public ConversationStatusEntity toJpa(ConversationStatus aggregate) {
        if (aggregate == null) return null;
        return new ConversationStatusEntity(aggregate.id().value(), aggregate.nameStatus(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ConversationStatus toDomain(ConversationStatusEntity entityObj) {
        if (entityObj == null) return null;
        return ConversationStatus.restore(new ConversationStatusId(entityObj.getId()), entityObj.getNameStatus(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
