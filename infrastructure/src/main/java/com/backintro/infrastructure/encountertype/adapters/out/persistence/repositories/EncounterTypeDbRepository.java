package com.backintro.infrastructure.encountertype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeEntity;

public interface EncounterTypeDbRepository extends DbRepository<EncounterTypeEntity, UUID> {
}
