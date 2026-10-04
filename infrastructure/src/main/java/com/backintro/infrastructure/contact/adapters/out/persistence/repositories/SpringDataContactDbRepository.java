package com.backintro.infrastructure.contact.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactEntity;

public interface SpringDataContactDbRepository extends DbRepository<ContactEntity, UUID> {
}
