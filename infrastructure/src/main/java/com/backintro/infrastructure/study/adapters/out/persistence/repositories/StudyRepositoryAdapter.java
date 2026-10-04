package com.backintro.infrastructure.study.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.infrastructure.study.adapters.out.persistence.entity.StudyEntity;
import com.backintro.infrastructure.study.adapters.out.persistence.mappers.StudyDataMapper;

public class StudyRepositoryAdapter implements StudyRepository {
    private final StudyDbRepository repository;
    private final StudyDataMapper mapper;

    public StudyRepositoryAdapter(StudyDbRepository repository, StudyDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Study save(Study aggregate) {
        StudyEntity entityObj = mapper.toJpa(aggregate);
        StudyEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Study> findById(StudyId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Study> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Study aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
