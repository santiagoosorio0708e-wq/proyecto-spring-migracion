package com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanEntity;

public interface SpringDataTreatmentPlanDbRepository extends DbRepository<TreatmentPlanEntity, UUID> {
}
