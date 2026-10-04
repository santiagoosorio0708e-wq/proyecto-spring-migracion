package com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.entity.AiModelEntity;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelDataMapper;

public class AiModelRepositoryAdapter implements AiModelRepository {
    private final AiModelDbRepository repository;
    private final AiModelDataMapper mapper;

    public AiModelRepositoryAdapter(AiModelDbRepository repository, AiModelDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AiModel save(AiModel aggregate) {
        AiModelEntity entityObj = mapper.toJpa(aggregate);
        AiModelEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiModel> findById(AiModelId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<AiModel> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(AiModel aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
