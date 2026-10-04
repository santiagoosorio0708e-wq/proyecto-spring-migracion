package com.backintro.infrastructure.treatmentplan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentplan.usecase.*;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanDataMapper;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories.*;

@Configuration
public class TreatmentPlanAppConfig {

    @Bean
    public TreatmentPlanDataMapper treatmentplanDataMapper() {
        return new TreatmentPlanDataMapper();
    }

    @Bean
    public TreatmentPlanRepository treatmentplanRepository(TreatmentPlanDbRepository repository, TreatmentPlanDataMapper mapper) {
        return new TreatmentPlanRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentPlanUseCase registerTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new RegisterTreatmentPlanUseCase(repository);
    }

    @Bean
    public GetTreatmentPlanByIdUseCase getTreatmentPlanByIdUseCase(TreatmentPlanRepository repository) {
        return new GetTreatmentPlanByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentPlanUseCase listTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new ListTreatmentPlanUseCase(repository);
    }

    @Bean
    public UpdateTreatmentPlanUseCase updateTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new UpdateTreatmentPlanUseCase(repository);
    }

    @Bean
    public DeleteTreatmentPlanUseCase deleteTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new DeleteTreatmentPlanUseCase(repository);
    }
}
