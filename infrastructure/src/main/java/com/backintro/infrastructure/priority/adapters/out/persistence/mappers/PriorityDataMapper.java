package com.backintro.infrastructure.priority.adapters.out.persistence.mappers;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityEntity;

public class PriorityDataMapper {
    public PriorityEntity toJpa(Priority aggregate) {
        if (aggregate == null) return null;
        return new PriorityEntity(aggregate.id().value(), aggregate.namePriority(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Priority toDomain(PriorityEntity entityObj) {
        if (entityObj == null) return null;
        return Priority.restore(new PriorityId(entityObj.getId()), entityObj.getNamePriority(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
