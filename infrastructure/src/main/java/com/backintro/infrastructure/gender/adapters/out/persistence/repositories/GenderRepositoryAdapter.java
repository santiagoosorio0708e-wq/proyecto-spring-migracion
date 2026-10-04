package com.backintro.infrastructure.gender.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderEntity;
import com.backintro.infrastructure.gender.adapters.out.persistence.mappers.GenderDataMapper;

public class GenderRepositoryAdapter implements GenderRepository {
    private final GenderDbRepository repository;
    private final GenderDataMapper mapper;

    public GenderRepositoryAdapter(GenderDbRepository repository, GenderDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Gender save(Gender aggregate) {
        GenderEntity entityObj = mapper.toJpa(aggregate);
        GenderEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Gender> findById(GenderId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Gender> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Gender aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
