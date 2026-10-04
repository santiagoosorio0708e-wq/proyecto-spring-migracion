package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryEntity;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryDataMapper;

public class CountryRepositoryAdapter implements CountryRepository {
    private final CountryDbRepository repository;
    private final CountryDataMapper mapper;

    public CountryRepositoryAdapter(CountryDbRepository repository, CountryDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Country save(Country aggregate) {
        CountryEntity entityObj = mapper.toJpa(aggregate);
        CountryEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Country aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
