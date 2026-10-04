package com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanEntity;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanDataMapper;

public class TreatmentPlanRepositoryAdapter implements TreatmentPlanRepository {
    private final TreatmentPlanDbRepository repository;
    private final TreatmentPlanDataMapper mapper;

    public TreatmentPlanRepositoryAdapter(TreatmentPlanDbRepository repository, TreatmentPlanDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentPlan save(TreatmentPlan aggregate) {
        TreatmentPlanEntity entityObj = mapper.toJpa(aggregate);
        TreatmentPlanEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentPlan> findById(TreatmentPlanId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<TreatmentPlan> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(TreatmentPlan aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
