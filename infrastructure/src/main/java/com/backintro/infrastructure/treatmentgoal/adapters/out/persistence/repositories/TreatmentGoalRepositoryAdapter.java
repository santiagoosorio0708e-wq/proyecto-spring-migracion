package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalEntity;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalDataMapper;

public class TreatmentGoalRepositoryAdapter implements TreatmentGoalRepository {
    private final TreatmentGoalDbRepository repository;
    private final TreatmentGoalDataMapper mapper;

    public TreatmentGoalRepositoryAdapter(TreatmentGoalDbRepository repository, TreatmentGoalDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentGoal save(TreatmentGoal aggregate) {
        TreatmentGoalEntity entityObj = mapper.toJpa(aggregate);
        TreatmentGoalEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoal> findById(TreatmentGoalId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<TreatmentGoal> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(TreatmentGoal aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
