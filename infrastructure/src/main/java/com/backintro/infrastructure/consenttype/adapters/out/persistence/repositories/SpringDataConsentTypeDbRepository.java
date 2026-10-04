package com.backintro.infrastructure.consenttype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeEntity;

public interface SpringDataConsentTypeDbRepository extends DbRepository<ConsentTypeEntity, UUID> {
}
