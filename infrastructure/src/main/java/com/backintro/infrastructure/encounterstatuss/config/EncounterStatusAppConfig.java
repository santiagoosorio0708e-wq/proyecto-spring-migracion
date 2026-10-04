package com.backintro.infrastructure.encounterstatuss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encounterstatuss.usecase.*;
import com.backintro.domain.encounterstatuss.port.repository.EncounterStatusRepository;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.mappers.EncounterStatusDataMapper;
import com.backintro.infrastructure.encounterstatuss.adapters.out.persistence.repositories.*;

@Configuration
public class EncounterStatusAppConfig {

    @Bean
    public EncounterStatusDataMapper encounterstatussDataMapper() {
        return new EncounterStatusDataMapper();
    }

    @Bean
    public EncounterStatusRepository encounterstatussRepository(EncounterStatusDbRepository repository, EncounterStatusDataMapper mapper) {
        return new EncounterStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterStatusUseCase registerEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new RegisterEncounterStatusUseCase(repository);
    }

    @Bean
    public GetEncounterStatusByIdUseCase getEncounterStatusByIdUseCase(EncounterStatusRepository repository) {
        return new GetEncounterStatusByIdUseCase(repository);
    }

    @Bean
    public ListEncounterStatusUseCase listEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new ListEncounterStatusUseCase(repository);
    }

    @Bean
    public UpdateEncounterStatusUseCase updateEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new UpdateEncounterStatusUseCase(repository);
    }

    @Bean
    public DeleteEncounterStatusUseCase deleteEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new DeleteEncounterStatusUseCase(repository);
    }
}
