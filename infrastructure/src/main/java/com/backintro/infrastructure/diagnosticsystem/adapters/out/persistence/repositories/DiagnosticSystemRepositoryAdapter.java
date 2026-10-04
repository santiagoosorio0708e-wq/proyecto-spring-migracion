package com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.entity.DiagnosticSystemEntity;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.mappers.DiagnosticSystemDataMapper;

public class DiagnosticSystemRepositoryAdapter implements DiagnosticSystemRepository {
    private final DiagnosticSystemDbRepository repository;
    private final DiagnosticSystemDataMapper mapper;

    public DiagnosticSystemRepositoryAdapter(DiagnosticSystemDbRepository repository, DiagnosticSystemDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DiagnosticSystem save(DiagnosticSystem aggregate) {
        DiagnosticSystemEntity entityObj = mapper.toJpa(aggregate);
        DiagnosticSystemEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<DiagnosticSystem> findById(DiagnosticSystemId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<DiagnosticSystem> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(DiagnosticSystem aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
