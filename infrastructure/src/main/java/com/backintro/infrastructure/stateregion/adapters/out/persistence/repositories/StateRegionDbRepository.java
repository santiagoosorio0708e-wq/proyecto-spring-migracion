package com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionEntity;

public interface StateRegionDbRepository extends DbRepository<StateRegionEntity, UUID> {
}
