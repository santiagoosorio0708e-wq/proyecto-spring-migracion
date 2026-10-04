package com.backintro.infrastructure.encountertype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encountertype.model.aggregate.EncounterType;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeEntity;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypeDataMapper;

public class EncounterTypeRepositoryAdapter implements EncounterTypeRepository {
    private final EncounterTypeDbRepository repository;
    private final EncounterTypeDataMapper mapper;

    public EncounterTypeRepositoryAdapter(EncounterTypeDbRepository repository, EncounterTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EncounterType save(EncounterType aggregate) {
        EncounterTypeEntity entityObj = mapper.toJpa(aggregate);
        EncounterTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterType> findById(EncounterTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EncounterType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EncounterType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
