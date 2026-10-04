package com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.escalationsstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.entity.EscalationStatusEntity;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.mappers.EscalationStatusDataMapper;

public class EscalationStatusRepositoryAdapter implements EscalationStatusRepository {
    private final EscalationStatusDbRepository repository;
    private final EscalationStatusDataMapper mapper;

    public EscalationStatusRepositoryAdapter(EscalationStatusDbRepository repository, EscalationStatusDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EscalationStatus save(EscalationStatus aggregate) {
        EscalationStatusEntity entityObj = mapper.toJpa(aggregate);
        EscalationStatusEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EscalationStatus> findById(EscalationStatusId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EscalationStatus> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EscalationStatus aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
