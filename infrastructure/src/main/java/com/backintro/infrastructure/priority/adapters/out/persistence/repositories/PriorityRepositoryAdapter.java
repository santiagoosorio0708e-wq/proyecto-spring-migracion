package com.backintro.infrastructure.priority.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.priority.model.aggregate.Priority;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.entity.PriorityEntity;
import com.backintro.infrastructure.priority.adapters.out.persistence.mappers.PriorityDataMapper;

public class PriorityRepositoryAdapter implements PriorityRepository {
    private final PriorityDbRepository repository;
    private final PriorityDataMapper mapper;

    public PriorityRepositoryAdapter(PriorityDbRepository repository, PriorityDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Priority save(Priority aggregate) {
        PriorityEntity entityObj = mapper.toJpa(aggregate);
        PriorityEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Priority> findById(PriorityId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Priority> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Priority aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
