package com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageEntity;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessageDataMapper;

public class ChatMessageRepositoryAdapter implements ChatMessageRepository {
    private final ChatMessageDbRepository repository;
    private final ChatMessageDataMapper mapper;

    public ChatMessageRepositoryAdapter(ChatMessageDbRepository repository, ChatMessageDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatMessage save(ChatMessage aggregate) {
        ChatMessageEntity entityObj = mapper.toJpa(aggregate);
        ChatMessageEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatMessage> findById(ChatMessageId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatMessage> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatMessage aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
