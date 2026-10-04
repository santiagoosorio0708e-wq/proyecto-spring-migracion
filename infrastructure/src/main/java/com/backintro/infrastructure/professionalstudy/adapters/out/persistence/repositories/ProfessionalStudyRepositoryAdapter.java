package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyEntity;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyDataMapper;

public class ProfessionalStudyRepositoryAdapter implements ProfessionalStudyRepository {
    private final ProfessionalStudyDbRepository repository;
    private final ProfessionalStudyDataMapper mapper;

    public ProfessionalStudyRepositoryAdapter(ProfessionalStudyDbRepository repository, ProfessionalStudyDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalStudy save(ProfessionalStudy aggregate) {
        ProfessionalStudyEntity entityObj = mapper.toJpa(aggregate);
        ProfessionalStudyEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalStudy> findById(ProfessionalStudyId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalStudy> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ProfessionalStudy aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
