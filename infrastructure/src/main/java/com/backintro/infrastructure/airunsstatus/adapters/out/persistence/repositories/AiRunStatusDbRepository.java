package com.backintro.infrastructure.airunsstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.entity.AiRunStatusEntity;

public interface AiRunStatusDbRepository extends DbRepository<AiRunStatusEntity, UUID> {
}
