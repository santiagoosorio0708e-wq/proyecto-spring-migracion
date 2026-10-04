package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeEntity;

public interface SpringDataRelationshipTypeDbRepository extends DbRepository<RelationshipTypeEntity, UUID> {
}
