package com.backintro.infrastructure.medicationroute.adapters.out.persistence.mappers;

import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteEntity;

public class MedicationRouteDataMapper {
    public MedicationRouteEntity toJpa(MedicationRoute aggregate) {
        if (aggregate == null) return null;
        return new MedicationRouteEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public MedicationRoute toDomain(MedicationRouteEntity entityObj) {
        if (entityObj == null) return null;
        return MedicationRoute.restore(new MedicationRouteId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
