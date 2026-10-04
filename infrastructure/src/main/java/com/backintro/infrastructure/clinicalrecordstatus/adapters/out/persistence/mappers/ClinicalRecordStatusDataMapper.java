package com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.mappers;

import com.backintro.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.entity.ClinicalRecordStatusEntity;

public class ClinicalRecordStatusDataMapper {
    public ClinicalRecordStatusEntity toJpa(ClinicalRecordStatus aggregate) {
        if (aggregate == null) return null;
        return new ClinicalRecordStatusEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ClinicalRecordStatus toDomain(ClinicalRecordStatusEntity entityObj) {
        if (entityObj == null) return null;
        return ClinicalRecordStatus.restore(new ClinicalRecordStatusId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
