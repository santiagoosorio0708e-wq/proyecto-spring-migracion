package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers;

import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricEntity;

public class ChatAiRunMetricDataMapper {
    public ChatAiRunMetricEntity toJpa(ChatAiRunMetric aggregate) {
        if (aggregate == null) return null;
        return new ChatAiRunMetricEntity(aggregate.id().value(), aggregate.aiRunId(), aggregate.promptTokens(), aggregate.completionTokens(), aggregate.totalTokens(), aggregate.cost(), aggregate.createdAt());
    }

    public ChatAiRunMetric toDomain(ChatAiRunMetricEntity entityObj) {
        if (entityObj == null) return null;
        return ChatAiRunMetric.restore(new ChatAiRunMetricId(entityObj.getId()), entityObj.getAiRunId(), entityObj.getPromptTokens(), entityObj.getCompletionTokens(), entityObj.getTotalTokens(), entityObj.getCost(), entityObj.getCreatedAt());
    }
}
