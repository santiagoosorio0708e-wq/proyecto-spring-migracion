package com.backintro.infrastructure.encountermodality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encountermodality.usecase.*;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityDataMapper;
import com.backintro.infrastructure.encountermodality.adapters.out.persistence.repositories.*;

@Configuration
public class EncounterModalityAppConfig {

    @Bean
    public EncounterModalityDataMapper encountermodalityDataMapper() {
        return new EncounterModalityDataMapper();
    }

    @Bean
    public EncounterModalityRepository encountermodalityRepository(EncounterModalityDbRepository repository, EncounterModalityDataMapper mapper) {
        return new EncounterModalityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterModalityUseCase registerEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new RegisterEncounterModalityUseCase(repository);
    }

    @Bean
    public GetEncounterModalityByIdUseCase getEncounterModalityByIdUseCase(EncounterModalityRepository repository) {
        return new GetEncounterModalityByIdUseCase(repository);
    }

    @Bean
    public ListEncounterModalityUseCase listEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new ListEncounterModalityUseCase(repository);
    }

    @Bean
    public UpdateEncounterModalityUseCase updateEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new UpdateEncounterModalityUseCase(repository);
    }

    @Bean
    public DeleteEncounterModalityUseCase deleteEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new DeleteEncounterModalityUseCase(repository);
    }
}
