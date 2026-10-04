package com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.entity.EscalationStatusEntity;

public interface EscalationStatusDbRepository extends DbRepository<EscalationStatusEntity, UUID> {
}
