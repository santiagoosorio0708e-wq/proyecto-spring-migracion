package com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.repositories;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamEntity;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.mappers.MentalStatusExamDataMapper;

public class MentalStatusExamRepositoryAdapter implements MentalStatusExamRepository {
    private final MentalStatusExamDbRepository repository;
    private final MentalStatusExamDataMapper mapper;

    public MentalStatusExamRepositoryAdapter(MentalStatusExamDbRepository repository, MentalStatusExamDataMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MentalStatusExam save(MentalStatusExam aggregate) {
        MentalStatusExamEntity entityObj = mapper.toJpa(aggregate);
        MentalStatusExamEntity saved = repository.save(entityObj);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MentalStatusExam> findById(MentalStatusExamId id) {
        return repository.findById(id.value()).map(mapper::toDomain);
    }

    @Override
    public List<MentalStatusExam> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(MentalStatusExam aggregate) {
        repository.deleteById(aggregate.id().value());
    }
}
