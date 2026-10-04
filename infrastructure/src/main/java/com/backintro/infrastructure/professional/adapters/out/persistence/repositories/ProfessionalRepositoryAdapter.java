package com.backintro.infrastructure.professional.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.entity.ProfessionalEntity;
import com.backintro.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalDataMapper;

public class ProfessionalRepositoryAdapter implements ProfessionalRepository {
    private final ProfessionalDbRepository repository;
    private final ProfessionalDataMapper mapper;

    public ProfessionalRepositoryAdapter(ProfessionalDbRepository repository, ProfessionalDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Professional save(Professional aggregate) {
        ProfessionalEntity entityObj = mapper.toJpa(aggregate);
        ProfessionalEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Professional> findById(ProfessionalId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Professional aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
