package com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantEntity;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantDataMapper;

public class ChatParticipantRepositoryAdapter implements ChatParticipantRepository {
    private final ChatParticipantDbRepository repository;
    private final ChatParticipantDataMapper mapper;

    public ChatParticipantRepositoryAdapter(ChatParticipantDbRepository repository, ChatParticipantDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatParticipant save(ChatParticipant aggregate) {
        ChatParticipantEntity entityObj = mapper.toJpa(aggregate);
        ChatParticipantEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatParticipant> findById(ChatParticipantId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatParticipant> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatParticipant aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
