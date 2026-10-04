package com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.encountermodality.model.aggregate.EncounterModality;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityEntity;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityDataMapper;

public class EncounterModalityRepositoryAdapter implements EncounterModalityRepository {
    private final EncounterModalityDbRepository repository;
    private final EncounterModalityDataMapper mapper;

    public EncounterModalityRepositoryAdapter(EncounterModalityDbRepository repository, EncounterModalityDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EncounterModality save(EncounterModality aggregate) {
        EncounterModalityEntity entityObj = mapper.toJpa(aggregate);
        EncounterModalityEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterModality> findById(EncounterModalityId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EncounterModality> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EncounterModality aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
