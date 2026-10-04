package com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.clinicalrecordstatus.adapters.out.persistence.entity.ClinicalRecordStatusEntity;

public interface ClinicalRecordStatusDbRepository extends DbRepository<ClinicalRecordStatusEntity, UUID> {
}
