package com.backintro.infrastructure.risklevel.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelEntity;

public interface RiskLevelDbRepository extends DbRepository<RiskLevelEntity, UUID> {
}
