package com.backintro.infrastructure.medicationroute.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteEntity;

public interface SpringDataMedicationRouteDbRepository extends DbRepository<MedicationRouteEntity, UUID> {
}
