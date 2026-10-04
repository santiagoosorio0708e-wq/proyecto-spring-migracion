package com.backintro.infrastructure.airunsstatus.adapters.out.persistence.mappers;

import com.backintro.domain.airunsstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.entity.AiRunStatusEntity;

public class AiRunStatusDataMapper {
    public AiRunStatusEntity toJpa(AiRunStatus aggregate) {
        if (aggregate == null) return null;
        return new AiRunStatusEntity(aggregate.id().value(), aggregate.nameStatus(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public AiRunStatus toDomain(AiRunStatusEntity entityObj) {
        if (entityObj == null) return null;
        return AiRunStatus.restore(new AiRunStatusId(entityObj.getId()), entityObj.getNameStatus(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
