package com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyEntity;

public interface SpringDataPatientAllergyDbRepository extends DbRepository<PatientAllergyEntity, UUID> {
}
