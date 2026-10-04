package com.backintro.infrastructure.chatairunerror.adapters.out.persistence.mappers;

import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.entity.ChatAiRunErrorEntity;

public class ChatAiRunErrorDataMapper {
    public ChatAiRunErrorEntity toJpa(ChatAiRunError aggregate) {
        if (aggregate == null) return null;
        return new ChatAiRunErrorEntity(aggregate.id().value(), aggregate.aiRunId(), aggregate.errorMessage(), aggregate.errorCode(), aggregate.providerErrorId(), aggregate.createdAt());
    }

    public ChatAiRunError toDomain(ChatAiRunErrorEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiRunError.restore(new ChatAiRunErrorId(entityObj.getId()), entityObj.getAiRunId(), entityObj.getErrorMessage(), entityObj.getErrorCode(), entityObj.getProviderErrorId(), entityObj.getCreatedAt());
    }
}
