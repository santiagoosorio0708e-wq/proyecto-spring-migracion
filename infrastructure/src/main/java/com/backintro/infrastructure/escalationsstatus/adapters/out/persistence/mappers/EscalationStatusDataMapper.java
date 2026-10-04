package com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.mappers;

import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.entity.EscalationStatusEntity;

public class EscalationStatusDataMapper {
    public EscalationStatusEntity toJpa(EscalationStatus aggregate) {
        if (aggregate == null) return null;
        return new EscalationStatusEntity(aggregate.id().value(), aggregate.nameStatus(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EscalationStatus toDomain(EscalationStatusEntity entityObj) {
        if (entityObj == null) return null;
        return EscalationStatus.restore(new EscalationStatusId(entityObj.getId()), entityObj.getNameStatus(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
