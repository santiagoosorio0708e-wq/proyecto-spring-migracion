package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeEntity;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypeDataMapper;

public class RelationshipTypeRepositoryAdapter implements RelationshipTypeRepository {
    private final RelationshipTypeDbRepository repository;
    private final RelationshipTypeDataMapper mapper;

    public RelationshipTypeRepositoryAdapter(RelationshipTypeDbRepository repository, RelationshipTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RelationshipType save(RelationshipType aggregate) {
        RelationshipTypeEntity entityObj = mapper.toJpa(aggregate);
        RelationshipTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RelationshipType> findById(RelationshipTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<RelationshipType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(RelationshipType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
