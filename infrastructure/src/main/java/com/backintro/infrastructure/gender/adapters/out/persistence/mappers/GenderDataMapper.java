package com.backintro.infrastructure.gender.adapters.out.persistence.mappers;

import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderEntity;

public class GenderDataMapper {
    public GenderEntity toJpa(Gender aggregate) {
        if (aggregate == null) return null;
        return new GenderEntity(aggregate.id().value(), aggregate.description(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Gender toDomain(GenderEntity entityObj) {
        if (entityObj == null) return null;
        return Gender.restore(new GenderId(entityObj.getId()), entityObj.getDescription(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
