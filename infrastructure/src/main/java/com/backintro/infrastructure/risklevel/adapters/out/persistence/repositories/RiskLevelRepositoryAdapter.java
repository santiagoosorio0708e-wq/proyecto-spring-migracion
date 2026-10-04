package com.backintro.infrastructure.risklevel.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelEntity;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.mappers.RiskLevelDataMapper;

public class RiskLevelRepositoryAdapter implements RiskLevelRepository {
    private final RiskLevelDbRepository repository;
    private final RiskLevelDataMapper mapper;

    public RiskLevelRepositoryAdapter(RiskLevelDbRepository repository, RiskLevelDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RiskLevel save(RiskLevel aggregate) {
        RiskLevelEntity entityObj = mapper.toJpa(aggregate);
        RiskLevelEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskLevel> findById(RiskLevelId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<RiskLevel> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(RiskLevel aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
