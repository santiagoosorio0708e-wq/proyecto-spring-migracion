package com.backintro.infrastructure.messagetype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeEntity;

public interface SpringDataMessageTypeDbRepository extends DbRepository<MessageTypeEntity, UUID> {
}
