package com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.entity.AiModelEntity;

public interface AiModelDbRepository extends DbRepository<AiModelEntity, UUID> {
}
