package com.backintro.infrastructure.providermodelsai.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.entity.ProviderModelAiEntity;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.mappers.ProviderModelAiDataMapper;

public class ProviderModelAiRepositoryAdapter implements ProviderModelAiRepository {
    private final ProviderModelAiDbRepository repository;
    private final ProviderModelAiDataMapper mapper;

    public ProviderModelAiRepositoryAdapter(ProviderModelAiDbRepository repository, ProviderModelAiDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProviderModelAi save(ProviderModelAi aggregate) {
        ProviderModelAiEntity entityObj = mapper.toJpa(aggregate);
        ProviderModelAiEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProviderModelAi> findById(ProviderModelAiId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProviderModelAi> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProviderModelAi aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
