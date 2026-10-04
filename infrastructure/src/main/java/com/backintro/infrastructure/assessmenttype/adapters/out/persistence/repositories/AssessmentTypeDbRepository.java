package com.backintro.infrastructure.assessmenttype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeEntity;

public interface AssessmentTypeDbRepository extends DbRepository<AssessmentTypeEntity, UUID> {
}
