package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalEntity;

public interface TreatmentGoalDbRepository extends DbRepository<TreatmentGoalEntity, UUID> {
}
