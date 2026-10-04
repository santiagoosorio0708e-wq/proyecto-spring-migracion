package com.backintro.infrastructure.chatairunerror.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.entity.ChatAiRunErrorEntity;
import com.backintro.infrastructure.chatairunerror.adapters.out.persistence.mappers.ChatAiRunErrorDataMapper;

public class ChatAiRunErrorRepositoryAdapter implements ChatAiRunErrorRepository {
    private final ChatAiRunErrorDbRepository repository;
    private final ChatAiRunErrorDataMapper mapper;

    public ChatAiRunErrorRepositoryAdapter(ChatAiRunErrorDbRepository repository, ChatAiRunErrorDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRunError save(ChatAiRunError aggregate) {
        ChatAiRunErrorEntity entityObj = mapper.toJpa(aggregate);
        ChatAiRunErrorEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunError> findById(ChatAiRunErrorId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRunError> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatAiRunError aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
