package com.backintro.infrastructure.assessmenttype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeEntity;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.mappers.AssessmentTypeDataMapper;

public class AssessmentTypeRepositoryAdapter implements AssessmentTypeRepository {
    private final AssessmentTypeDbRepository repository;
    private final AssessmentTypeDataMapper mapper;

    public AssessmentTypeRepositoryAdapter(AssessmentTypeDbRepository repository, AssessmentTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AssessmentType save(AssessmentType aggregate) {
        AssessmentTypeEntity entityObj = mapper.toJpa(aggregate);
        AssessmentTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AssessmentType> findById(AssessmentTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<AssessmentType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(AssessmentType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
