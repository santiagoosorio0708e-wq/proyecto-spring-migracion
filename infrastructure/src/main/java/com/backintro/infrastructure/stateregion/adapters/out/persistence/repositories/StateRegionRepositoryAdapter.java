package com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionEntity;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionDataMapper;

public class StateRegionRepositoryAdapter implements StateRegionRepository {
    private final StateRegionDbRepository repository;
    private final StateRegionDataMapper mapper;

    public StateRegionRepositoryAdapter(StateRegionDbRepository repository, StateRegionDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StateRegion save(StateRegion aggregate) {
        StateRegionEntity entityObj = mapper.toJpa(aggregate);
        StateRegionEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<StateRegion> findById(StateRegionId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<StateRegion> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(StateRegion aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
