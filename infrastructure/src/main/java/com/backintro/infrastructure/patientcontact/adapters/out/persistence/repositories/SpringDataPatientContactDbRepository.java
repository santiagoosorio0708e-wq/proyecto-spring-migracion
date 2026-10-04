package com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactEntity;

public interface SpringDataPatientContactDbRepository extends DbRepository<PatientContactEntity, UUID> {
}
