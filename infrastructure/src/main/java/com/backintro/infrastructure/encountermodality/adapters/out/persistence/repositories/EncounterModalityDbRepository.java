package com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityEntity;

public interface EncounterModalityDbRepository extends DbRepository<EncounterModalityEntity, UUID> {
}
