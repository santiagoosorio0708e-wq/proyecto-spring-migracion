package com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.treatmentstatuss.model.aggregate.TreatmentStatus;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;
import com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.entity.TreatmentStatusEntity;
import com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.mappers.TreatmentStatusDataMapper;

public class TreatmentStatusRepositoryAdapter implements TreatmentStatusRepository {
    private final TreatmentStatusDbRepository repository;
    private final TreatmentStatusDataMapper mapper;

    public TreatmentStatusRepositoryAdapter(TreatmentStatusDbRepository repository, TreatmentStatusDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentStatus save(TreatmentStatus aggregate) {
        TreatmentStatusEntity entityObj = mapper.toJpa(aggregate);
        TreatmentStatusEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentStatus> findById(TreatmentStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<TreatmentStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(TreatmentStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
