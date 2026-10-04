package com.backintro.infrastructure.professional.adapters.out.persistence.mappers;

import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.infrastructure.professional.adapters.out.persistence.entity.ProfessionalEntity;

public class ProfessionalDataMapper {
    public ProfessionalEntity toJpa(Professional aggregate) {
        if (aggregate == null) return null;
        return new ProfessionalEntity(aggregate.id().value(), aggregate.documentTypeId(), aggregate.documentNumber(), aggregate.firstName(), aggregate.lastName(), aggregate.professionalTypeId(), aggregate.licenseNumber(), aggregate.active(), aggregate.cityId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Professional toDomain(ProfessionalEntity entityObj) {
        if (entityObj == null) return null;
        return Professional.restore(new ProfessionalId(entityObj.getId()), entityObj.getDocumentTypeId(), entityObj.getDocumentNumber(), entityObj.getFirstName(), entityObj.getLastName(), entityObj.getProfessionalTypeId(), entityObj.getLicenseNumber(), entityObj.getActive(), entityObj.getCityId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
