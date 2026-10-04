package com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactEntity;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactDataMapper;

public class PatientContactRepositoryAdapter implements PatientContactRepository {
    private final PatientContactDbRepository repository;
    private final PatientContactDataMapper mapper;

    public PatientContactRepositoryAdapter(PatientContactDbRepository repository, PatientContactDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PatientContact save(PatientContact aggregate) {
        PatientContactEntity entityObj = mapper.toJpa(aggregate);
        PatientContactEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PatientContact> findById(PatientContactId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<PatientContact> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(PatientContact aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
