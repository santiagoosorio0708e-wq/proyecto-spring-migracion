package com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactEntity;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactDataMapper;

public class PhoneContactRepositoryAdapter implements PhoneContactRepository {
    private final PhoneContactDbRepository repository;
    private final PhoneContactDataMapper mapper;

    public PhoneContactRepositoryAdapter(PhoneContactDbRepository repository, PhoneContactDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PhoneContact save(PhoneContact aggregate) {
        PhoneContactEntity entityObj = mapper.toJpa(aggregate);
        PhoneContactEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PhoneContact> findById(PhoneContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PhoneContact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PhoneContact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
