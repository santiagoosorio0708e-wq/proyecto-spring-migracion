package com.backintro.infrastructure.clinicalrecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.clinicalrecord.usecase.*;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordDataMapper;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories.*;

@Configuration
public class ClinicalRecordAppConfig {

    @Bean
    public ClinicalRecordDataMapper clinicalrecordDataMapper() {
        return new ClinicalRecordDataMapper();
    }

    @Bean
    public ClinicalRecordRepository clinicalrecordRepository(ClinicalRecordDbRepository repository, ClinicalRecordDataMapper mapper) {
        return new ClinicalRecordRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalRecordUseCase registerClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new RegisterClinicalRecordUseCase(repository);
    }

    @Bean
    public GetClinicalRecordByIdUseCase getClinicalRecordByIdUseCase(ClinicalRecordRepository repository) {
        return new GetClinicalRecordByIdUseCase(repository);
    }

    @Bean
    public ListClinicalRecordUseCase listClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new ListClinicalRecordUseCase(repository);
    }

    @Bean
    public UpdateClinicalRecordUseCase updateClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new UpdateClinicalRecordUseCase(repository);
    }

    @Bean
    public DeleteClinicalRecordUseCase deleteClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new DeleteClinicalRecordUseCase(repository);
    }
}
