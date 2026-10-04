package com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.entity.ChatEscalationAssignmentEntity;

public interface ChatEscalationAssignmentDbRepository extends DbRepository<ChatEscalationAssignmentEntity, UUID> {
}
