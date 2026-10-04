package com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.entity.TreatmentGoalStatusEntity;

public interface TreatmentGoalStatusDbRepository extends DbRepository<TreatmentGoalStatusEntity, UUID> {
}
