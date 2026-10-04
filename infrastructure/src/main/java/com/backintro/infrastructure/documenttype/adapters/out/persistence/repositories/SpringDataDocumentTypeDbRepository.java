package com.backintro.infrastructure.documenttype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.entity.DocumentTypeEntity;

public interface SpringDataDocumentTypeDbRepository extends DbRepository<DocumentTypeEntity, UUID> {
}
