package com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.mappers;

import com.backintro.domain.encounterstatuss.model.aggregate.EncounterStatus;
import com.backintro.domain.encounterstatuss.model.valueobject.EncounterStatusId;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.entity.EncounterStatusEntity;

public class EncounterStatusDataMapper {
    public EncounterStatusEntity toJpa(EncounterStatus aggregate) {
        if (aggregate == null) return null;
        return new EncounterStatusEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EncounterStatus toDomain(EncounterStatusEntity entityObj) {
        if (entityObj == null) return null;
        return EncounterStatus.restore(new EncounterStatusId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
