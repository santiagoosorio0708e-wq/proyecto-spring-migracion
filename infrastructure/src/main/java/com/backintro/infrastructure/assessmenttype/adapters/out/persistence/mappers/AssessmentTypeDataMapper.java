package com.backintro.infrastructure.assessmenttype.adapters.out.persistence.mappers;

import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeEntity;

public class AssessmentTypeDataMapper {
    public AssessmentTypeEntity toJpa(AssessmentType aggregate) {
        if (aggregate == null) return null;
        return new AssessmentTypeEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.description(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public AssessmentType toDomain(AssessmentTypeEntity entityObj) {
        if (entityObj == null) return null;
        return AssessmentType.restore(new AssessmentTypeId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getDescription(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
