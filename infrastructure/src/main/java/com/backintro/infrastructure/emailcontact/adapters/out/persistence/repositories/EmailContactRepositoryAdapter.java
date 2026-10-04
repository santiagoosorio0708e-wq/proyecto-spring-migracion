package com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactEntity;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactDataMapper;

public class EmailContactRepositoryAdapter implements EmailContactRepository {
    private final EmailContactDbRepository repository;
    private final EmailContactDataMapper mapper;

    public EmailContactRepositoryAdapter(EmailContactDbRepository repository, EmailContactDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmailContact save(EmailContact aggregate) {
        EmailContactEntity entityObj = mapper.toJpa(aggregate);
        EmailContactEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EmailContact> findById(EmailContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<EmailContact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(EmailContact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
