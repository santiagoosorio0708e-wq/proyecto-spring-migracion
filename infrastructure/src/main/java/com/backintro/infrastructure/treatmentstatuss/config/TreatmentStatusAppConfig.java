package com.backintro.infrastructure.treatmentstatuss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentstatuss.usecase.*;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;
import com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.mappers.TreatmentStatusDataMapper;
import com.backintro.infrastructure.treatmentstatuss.adapters.out.persistence.repositories.*;

@Configuration
public class TreatmentStatusAppConfig {

    @Bean
    public TreatmentStatusDataMapper treatmentstatussDataMapper() {
        return new TreatmentStatusDataMapper();
    }

    @Bean
    public TreatmentStatusRepository treatmentstatussRepository(TreatmentStatusDbRepository repository, TreatmentStatusDataMapper mapper) {
        return new TreatmentStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentStatusUseCase registerTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new RegisterTreatmentStatusUseCase(repository);
    }

    @Bean
    public GetTreatmentStatusByIdUseCase getTreatmentStatusByIdUseCase(TreatmentStatusRepository repository) {
        return new GetTreatmentStatusByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentStatusUseCase listTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new ListTreatmentStatusUseCase(repository);
    }

    @Bean
    public UpdateTreatmentStatusUseCase updateTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new UpdateTreatmentStatusUseCase(repository);
    }

    @Bean
    public DeleteTreatmentStatusUseCase deleteTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new DeleteTreatmentStatusUseCase(repository);
    }
}
