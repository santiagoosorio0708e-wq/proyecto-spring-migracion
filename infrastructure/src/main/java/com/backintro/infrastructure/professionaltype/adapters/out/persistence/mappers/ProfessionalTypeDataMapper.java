package com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers;

import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeEntity;

public class ProfessionalTypeDataMapper {
    public ProfessionalTypeEntity toJpa(ProfessionalType aggregate) {
        if (aggregate == null) return null;
        return new ProfessionalTypeEntity(aggregate.id().value(), aggregate.name(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ProfessionalType toDomain(ProfessionalTypeEntity entityObj) {
        if (entityObj == null) return null;
        return ProfessionalType.restore(new ProfessionalTypeId(entityObj.getId()), entityObj.getName(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
