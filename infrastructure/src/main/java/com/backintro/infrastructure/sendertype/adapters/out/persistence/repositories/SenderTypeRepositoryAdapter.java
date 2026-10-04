package com.backintro.infrastructure.sendertype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeEntity;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypeDataMapper;

public class SenderTypeRepositoryAdapter implements SenderTypeRepository {
    private final SenderTypeDbRepository repository;
    private final SenderTypeDataMapper mapper;

    public SenderTypeRepositoryAdapter(SenderTypeDbRepository repository, SenderTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SenderType save(SenderType aggregate) {
        SenderTypeEntity entityObj = mapper.toJpa(aggregate);
        SenderTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<SenderType> findById(SenderTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<SenderType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(SenderType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
