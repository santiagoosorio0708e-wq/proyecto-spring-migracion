package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricEntity;
import com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricDataMapper;

public class ChatAiRunMetricRepositoryAdapter implements ChatAiRunMetricRepository {
    private final ChatAiRunMetricDbRepository repository;
    private final ChatAiRunMetricDataMapper mapper;

    public ChatAiRunMetricRepositoryAdapter(ChatAiRunMetricDbRepository repository, ChatAiRunMetricDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRunMetric save(ChatAiRunMetric aggregate) {
        ChatAiRunMetricEntity entityObj = mapper.toJpa(aggregate);
        ChatAiRunMetricEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRunMetric> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiRunMetric aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
