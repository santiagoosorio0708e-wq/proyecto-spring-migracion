package com.backintro.infrastructure.patient.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.entity.PatientEntity;
import com.backintro.infrastructure.patient.adapters.out.persistence.mappers.PatientDataMapper;

public class PatientRepositoryAdapter implements PatientRepository {
    private final PatientDbRepository repository;
    private final PatientDataMapper mapper;

    public PatientRepositoryAdapter(PatientDbRepository repository, PatientDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient aggregate) {
        PatientEntity entityObj = mapper.toJpa(aggregate);
        PatientEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Patient> findById(PatientId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Patient aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
