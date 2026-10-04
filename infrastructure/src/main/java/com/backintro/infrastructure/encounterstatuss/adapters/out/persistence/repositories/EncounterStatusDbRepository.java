package com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.entity.EncounterStatusEntity;

public interface EncounterStatusDbRepository extends DbRepository<EncounterStatusEntity, UUID> {
}
