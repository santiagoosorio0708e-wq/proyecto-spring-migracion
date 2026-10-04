package com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatairun.model.aggregate.ChatAiRun;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunEntity;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunDataMapper;

public class ChatAiRunRepositoryAdapter implements ChatAiRunRepository {
    private final ChatAiRunDbRepository repository;
    private final ChatAiRunDataMapper mapper;

    public ChatAiRunRepositoryAdapter(ChatAiRunDbRepository repository, ChatAiRunDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRun save(ChatAiRun aggregate) {
        ChatAiRunEntity entityObj = mapper.toJpa(aggregate);
        ChatAiRunEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRun> findById(ChatAiRunId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRun> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiRun aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
