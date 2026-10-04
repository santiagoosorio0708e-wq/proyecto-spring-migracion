package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryEntity;

public interface ChatEscalationStatusHistoryDbRepository extends DbRepository<ChatEscalationStatusHistoryEntity, UUID> {
}
