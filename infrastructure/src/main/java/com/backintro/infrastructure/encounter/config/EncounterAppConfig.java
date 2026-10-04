package com.backintro.infrastructure.encounter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encounter.usecase.*;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.infrastructure.encounter.adapters.out.persistence.mappers.EncounterDataMapper;
import com.backintro.infrastructure.encounter.adapters.out.persistence.repositories.*;

@Configuration
public class EncounterAppConfig {

    @Bean
    public EncounterDataMapper encounterDataMapper() {
        return new EncounterDataMapper();
    }

    @Bean
    public EncounterRepository encounterRepository(EncounterDbRepository repository, EncounterDataMapper mapper) {
        return new EncounterRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterUseCase registerEncounterUseCase(EncounterRepository repository) {
        return new RegisterEncounterUseCase(repository);
    }

    @Bean
    public GetEncounterByIdUseCase getEncounterByIdUseCase(EncounterRepository repository) {
        return new GetEncounterByIdUseCase(repository);
    }

    @Bean
    public ListEncounterUseCase listEncounterUseCase(EncounterRepository repository) {
        return new ListEncounterUseCase(repository);
    }

    @Bean
    public UpdateEncounterUseCase updateEncounterUseCase(EncounterRepository repository) {
        return new UpdateEncounterUseCase(repository);
    }

    @Bean
    public DeleteEncounterUseCase deleteEncounterUseCase(EncounterRepository repository) {
        return new DeleteEncounterUseCase(repository);
    }
}
