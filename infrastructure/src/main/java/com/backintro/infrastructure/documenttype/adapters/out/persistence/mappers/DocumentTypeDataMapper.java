package com.backintro.infrastructure.documenttype.adapters.out.persistence.mappers;

import com.backintro.domain.documenttype.model.aggregate.DocumentType;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.entity.DocumentTypeEntity;

public class DocumentTypeDataMapper {
    public DocumentTypeEntity toJpa(DocumentType aggregate) {
        if (aggregate == null) return null;
        return new DocumentTypeEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public DocumentType toDomain(DocumentTypeEntity entityObj) {
        if (entityObj == null) return null;
        return DocumentType.restore(new DocumentTypeId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
