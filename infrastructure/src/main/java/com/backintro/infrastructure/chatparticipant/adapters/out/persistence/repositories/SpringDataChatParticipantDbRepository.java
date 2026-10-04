package com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantEntity;

public interface SpringDataChatParticipantDbRepository extends DbRepository<ChatParticipantEntity, UUID> {
}
