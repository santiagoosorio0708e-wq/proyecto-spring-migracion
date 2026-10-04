package com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationEntity;

public interface ChatEscalationDbRepository extends DbRepository<ChatEscalationEntity, UUID> {
}
