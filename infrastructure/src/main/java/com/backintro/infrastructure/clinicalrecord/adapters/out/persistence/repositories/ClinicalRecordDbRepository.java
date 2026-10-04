package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordEntity;

public interface ClinicalRecordDbRepository extends DbRepository<ClinicalRecordEntity, UUID> {
}
