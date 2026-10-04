package com.backintro.infrastructure.patient.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientEntity;

public interface SpringDataPatientDbRepository extends DbRepository<PatientEntity, UUID> {
}
