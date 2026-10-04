package com.backintro.infrastructure.sendertype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeEntity;

public interface SenderTypeDbRepository extends DbRepository<SenderTypeEntity, UUID> {
}
