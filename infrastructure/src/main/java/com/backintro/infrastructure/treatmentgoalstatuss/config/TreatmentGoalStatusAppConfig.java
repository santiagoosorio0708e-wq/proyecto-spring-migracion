package com.backintro.infrastructure.treatmentgoalstatuss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentgoalstatuss.usecase.*;
import com.backintro.domain.treatmentgoalstatuss.port.repository.TreatmentGoalStatusRepository;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.mappers.TreatmentGoalStatusDataMapper;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.out.persistence.repositories.*;

@Configuration
public class TreatmentGoalStatusAppConfig {

    @Bean
    public TreatmentGoalStatusDataMapper treatmentgoalstatussDataMapper() {
        return new TreatmentGoalStatusDataMapper();
    }

    @Bean
    public TreatmentGoalStatusRepository treatmentgoalstatussRepository(TreatmentGoalStatusDbRepository repository, TreatmentGoalStatusDataMapper mapper) {
        return new TreatmentGoalStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentGoalStatusUseCase registerTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new RegisterTreatmentGoalStatusUseCase(repository);
    }

    @Bean
    public GetTreatmentGoalStatusByIdUseCase getTreatmentGoalStatusByIdUseCase(TreatmentGoalStatusRepository repository) {
        return new GetTreatmentGoalStatusByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentGoalStatusUseCase listTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new ListTreatmentGoalStatusUseCase(repository);
    }

    @Bean
    public UpdateTreatmentGoalStatusUseCase updateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new UpdateTreatmentGoalStatusUseCase(repository);
    }

    @Bean
    public DeleteTreatmentGoalStatusUseCase deleteTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new DeleteTreatmentGoalStatusUseCase(repository);
    }
}
