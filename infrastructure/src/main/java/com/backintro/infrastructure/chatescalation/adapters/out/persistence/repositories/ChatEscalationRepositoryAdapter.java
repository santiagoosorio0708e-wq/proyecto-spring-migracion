package com.backintro.infrastructure.chatescalation.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationEntity;
import com.backintro.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationDataMapper;

public class ChatEscalationRepositoryAdapter implements ChatEscalationRepository {
    private final ChatEscalationDbRepository repository;
    private final ChatEscalationDataMapper mapper;

    public ChatEscalationRepositoryAdapter(ChatEscalationDbRepository repository, ChatEscalationDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalation save(ChatEscalation aggregate) {
        ChatEscalationEntity entityObj = mapper.toJpa(aggregate);
        ChatEscalationEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalation> findById(ChatEscalationId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalation> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatEscalation aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
