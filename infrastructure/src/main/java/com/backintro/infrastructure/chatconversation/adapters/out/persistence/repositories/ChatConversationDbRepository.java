package com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationEntity;

public interface ChatConversationDbRepository extends DbRepository<ChatConversationEntity, UUID> {
}
