package com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryEntity;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers.ChatEscalationStatusHistoryDataMapper;

public class ChatEscalationStatusHistoryRepositoryAdapter implements ChatEscalationStatusHistoryRepository {
    private final ChatEscalationStatusHistoryDbRepository repository;
    private final ChatEscalationStatusHistoryDataMapper mapper;

    public ChatEscalationStatusHistoryRepositoryAdapter(ChatEscalationStatusHistoryDbRepository repository, ChatEscalationStatusHistoryDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalationStatusHistory save(ChatEscalationStatusHistory aggregate) {
        ChatEscalationStatusHistoryEntity entityObj = mapper.toJpa(aggregate);
        ChatEscalationStatusHistoryEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalationStatusHistory> findById(ChatEscalationStatusHistoryId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalationStatusHistory> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatEscalationStatusHistory aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
