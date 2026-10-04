package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers;

import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyEntity;

public class ProfessionalStudyDataMapper {
    public ProfessionalStudyEntity toJpa(ProfessionalStudy aggregate) {
        if (aggregate == null) return null;
        return new ProfessionalStudyEntity(aggregate.id().value(), aggregate.studyId(), aggregate.professionalId(), aggregate.title(), aggregate.university(), aggregate.isValid(), aggregate.resolutionNumber(), aggregate.countryId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ProfessionalStudy toDomain(ProfessionalStudyEntity entityObj) {
        if (entityObj == null) return null;
        return ProfessionalStudy.restore(new ProfessionalStudyId(entityObj.getId()), entityObj.getStudyId(), entityObj.getProfessionalId(), entityObj.getTitle(), entityObj.getUniversity(), entityObj.getIsValid(), entityObj.getResolutionNumber(), entityObj.getCountryId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
