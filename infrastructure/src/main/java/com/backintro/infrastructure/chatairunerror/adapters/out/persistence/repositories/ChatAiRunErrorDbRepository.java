package com.backintro.infrastructure.chatairunerror.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.entity.ChatAiRunErrorEntity;

public interface ChatAiRunErrorDbRepository extends DbRepository<ChatAiRunErrorEntity, UUID> {
}
