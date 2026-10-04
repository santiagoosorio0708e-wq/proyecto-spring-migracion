package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteEntity;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNoteDataMapper;

public class ClinicalNoteRepositoryAdapter implements ClinicalNoteRepository {
    private final ClinicalNoteDbRepository repository;
    private final ClinicalNoteDataMapper mapper;

    public ClinicalNoteRepositoryAdapter(ClinicalNoteDbRepository repository, ClinicalNoteDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalNote save(ClinicalNote aggregate) {
        ClinicalNoteEntity entityObj = mapper.toJpa(aggregate);
        ClinicalNoteEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalNote> findById(ClinicalNoteId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<ClinicalNote> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(ClinicalNote aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
