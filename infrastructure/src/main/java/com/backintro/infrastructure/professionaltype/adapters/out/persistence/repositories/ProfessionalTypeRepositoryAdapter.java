package com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professionaltype.model.aggregate.ProfessionalType;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeEntity;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypeDataMapper;

public class ProfessionalTypeRepositoryAdapter implements ProfessionalTypeRepository {
    private final ProfessionalTypeDbRepository repository;
    private final ProfessionalTypeDataMapper mapper;

    public ProfessionalTypeRepositoryAdapter(ProfessionalTypeDbRepository repository, ProfessionalTypeDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalType save(ProfessionalType aggregate) {
        ProfessionalTypeEntity entityObj = mapper.toJpa(aggregate);
        ProfessionalTypeEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalType> findById(ProfessionalTypeId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalType> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProfessionalType aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
