package com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentEntity;

public interface RiskAssessmentDbRepository extends DbRepository<RiskAssessmentEntity, UUID> {
}
