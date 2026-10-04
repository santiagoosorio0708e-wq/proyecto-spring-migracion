package com.backintro.infrastructure.encounter.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.entity.EncounterEntity;

public interface EncounterDbRepository extends DbRepository<EncounterEntity, UUID> {
}
