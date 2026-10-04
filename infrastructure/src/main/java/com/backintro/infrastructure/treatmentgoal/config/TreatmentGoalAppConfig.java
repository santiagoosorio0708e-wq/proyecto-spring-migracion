package com.backintro.infrastructure.treatmentgoal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentgoal.usecase.*;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalDataMapper;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories.*;

@Configuration
public class TreatmentGoalAppConfig {

    @Bean
    public TreatmentGoalDataMapper treatmentgoalDataMapper() {
        return new TreatmentGoalDataMapper();
    }

    @Bean
    public TreatmentGoalRepository treatmentgoalRepository(TreatmentGoalDbRepository repository, TreatmentGoalDataMapper mapper) {
        return new TreatmentGoalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentGoalUseCase registerTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new RegisterTreatmentGoalUseCase(repository);
    }

    @Bean
    public GetTreatmentGoalByIdUseCase getTreatmentGoalByIdUseCase(TreatmentGoalRepository repository) {
        return new GetTreatmentGoalByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentGoalUseCase listTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new ListTreatmentGoalUseCase(repository);
    }

    @Bean
    public UpdateTreatmentGoalUseCase updateTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new UpdateTreatmentGoalUseCase(repository);
    }

    @Bean
    public DeleteTreatmentGoalUseCase deleteTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new DeleteTreatmentGoalUseCase(repository);
    }
}
