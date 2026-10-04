package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityEntity;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityDataMapper;

public class CityMunicipalityRepositoryAdapter implements CityMunicipalityRepository {
    private final CityMunicipalityDbRepository repository;
    private final CityMunicipalityDataMapper mapper;

    public CityMunicipalityRepositoryAdapter(CityMunicipalityDbRepository repository, CityMunicipalityDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CityMunicipality save(CityMunicipality aggregate) {
        CityMunicipalityEntity entityObj = mapper.toJpa(aggregate);
        CityMunicipalityEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CityMunicipality> findById(CityMunicipalityId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<CityMunicipality> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(CityMunicipality aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
