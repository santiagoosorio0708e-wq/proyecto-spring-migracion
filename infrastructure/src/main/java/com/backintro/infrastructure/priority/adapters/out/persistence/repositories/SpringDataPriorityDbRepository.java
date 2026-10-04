package com.backintro.infrastructure.priority.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityEntity;

public interface SpringDataPriorityDbRepository extends DbRepository<PriorityEntity, UUID> {
}
