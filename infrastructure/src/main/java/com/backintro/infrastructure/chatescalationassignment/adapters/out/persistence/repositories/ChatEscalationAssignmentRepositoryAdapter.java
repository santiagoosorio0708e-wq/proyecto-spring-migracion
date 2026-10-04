package com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.entity.ChatEscalationAssignmentEntity;
import com.backintro.infrastructure.chatescalationassignment.adapters.out.persistence.mappers.ChatEscalationAssignmentDataMapper;

public class ChatEscalationAssignmentRepositoryAdapter implements ChatEscalationAssignmentRepository {
    private final ChatEscalationAssignmentDbRepository repository;
    private final ChatEscalationAssignmentDataMapper mapper;

    public ChatEscalationAssignmentRepositoryAdapter(ChatEscalationAssignmentDbRepository repository, ChatEscalationAssignmentDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalationAssignment save(ChatEscalationAssignment aggregate) {
        ChatEscalationAssignmentEntity entityObj = mapper.toJpa(aggregate);
        ChatEscalationAssignmentEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalationAssignment> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ChatEscalationAssignment aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
