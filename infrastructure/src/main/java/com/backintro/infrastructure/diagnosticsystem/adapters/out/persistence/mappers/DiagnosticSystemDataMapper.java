package com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.mappers;

import com.backintro.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.entity.DiagnosticSystemEntity;

public class DiagnosticSystemDataMapper {
    public DiagnosticSystemEntity toJpa(DiagnosticSystem aggregate) {
        if (aggregate == null) return null;
        return new DiagnosticSystemEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.version(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public DiagnosticSystem toDomain(DiagnosticSystemEntity entityObj) {
        if (entityObj == null) return null;
        return DiagnosticSystem.restore(new DiagnosticSystemId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getVersion(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
