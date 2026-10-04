package com.backintro.infrastructure.riskassessment.adapters.out.persistence.mappers;

import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentEntity;

public class RiskAssessmentDataMapper {
    public RiskAssessmentEntity toJpa(RiskAssessment aggregate) {
        if (aggregate == null) return null;
        return new RiskAssessmentEntity(aggregate.id().value(), aggregate.encounterId(), aggregate.riskLevelId(), aggregate.suicidalIdeation(), aggregate.suicidePlan(), aggregate.suicideIntent(), aggregate.selfHarm(), aggregate.harmToOthers(), aggregate.protectiveFactors(), aggregate.riskFactors(), aggregate.clinicalActions(), aggregate.observations(), aggregate.assessedAt(), aggregate.assessedBy());
    }

    public RiskAssessment toDomain(RiskAssessmentEntity entityObj) {
        if (entityObj == null) return null;
        return RiskAssessment.restore(new RiskAssessmentId(entityObj.getId()), entityObj.getEncounterId(), entityObj.getRiskLevelId(), entityObj.getSuicidalIdeation(), entityObj.getSuicidePlan(), entityObj.getSuicideIntent(), entityObj.getSelfHarm(), entityObj.getHarmToOthers(), entityObj.getProtectiveFactors(), entityObj.getRiskFactors(), entityObj.getClinicalActions(), entityObj.getObservations(), entityObj.getAssessedAt(), entityObj.getAssessedBy());
    }
}
