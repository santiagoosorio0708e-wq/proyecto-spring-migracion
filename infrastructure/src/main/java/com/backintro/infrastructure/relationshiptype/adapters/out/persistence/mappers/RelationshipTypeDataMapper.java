package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers;

import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeEntity;

public class RelationshipTypeDataMapper {
    public RelationshipTypeEntity toJpa(RelationshipType aggregate) {
        if (aggregate == null) return null;
        return new RelationshipTypeEntity(aggregate.id().value(), aggregate.description());
    }

    public RelationshipType toDomain(RelationshipTypeEntity entityObj) {
        if (entityObj == null) return null;
        return RelationshipType.restore(new RelationshipTypeId(entityObj.getId()), entityObj.getDescription());
    }
}
