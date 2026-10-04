package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteEntity;

public interface ClinicalNoteDbRepository extends DbRepository<ClinicalNoteEntity, UUID> {
}
