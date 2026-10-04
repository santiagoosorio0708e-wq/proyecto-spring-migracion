package com.backintro.infrastructure.medicationroute.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteEntity;

public interface MedicationRouteDbRepository extends DbRepository<MedicationRouteEntity, UUID> {
}
