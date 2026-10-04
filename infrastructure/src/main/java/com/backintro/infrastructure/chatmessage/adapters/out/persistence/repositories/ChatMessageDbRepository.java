package com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageEntity;

public interface ChatMessageDbRepository extends DbRepository<ChatMessageEntity, UUID> {
}
