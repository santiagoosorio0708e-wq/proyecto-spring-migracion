package com.backintro.infrastructure.messagetype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeEntity;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypeDataMapper;

public class MessageTypeRepositoryAdapter implements MessageTypeRepository {
    private final MessageTypeDbRepository repository;
    private final MessageTypeDataMapper mapper;

    public MessageTypeRepositoryAdapter(MessageTypeDbRepository repository, MessageTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MessageType save(MessageType aggregate) {
        MessageTypeEntity entityObj = mapper.toJpa(aggregate);
        MessageTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MessageType> findById(MessageTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<MessageType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(MessageType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
