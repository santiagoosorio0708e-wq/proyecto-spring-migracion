package com.backintro.infrastructure.chatconversation.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatconversation.model.aggregate.ChatConversation;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.domain.chatconversation.port.repository.ChatConversationRepository;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationEntity;
import com.backintro.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationDataMapper;

public class ChatConversationRepositoryAdapter implements ChatConversationRepository {
    private final ChatConversationDbRepository repository;
    private final ChatConversationDataMapper mapper;

    public ChatConversationRepositoryAdapter(ChatConversationDbRepository repository, ChatConversationDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatConversation save(ChatConversation aggregate) {
        ChatConversationEntity entityObj = mapper.toJpa(aggregate);
        ChatConversationEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatConversation> findById(ChatConversationId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatConversation> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatConversation aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
