package com.backintro.infrastructure.airunsstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.airunsstatus.usecase.*;
import com.backintro.domain.airunsstatus.port.repository.AiRunStatusRepository;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.mappers.AiRunStatusDataMapper;
import com.backintro.infrastructure.airunsstatus.adapters.out.persistence.repositories.*;

@Configuration
public class AiRunStatusAppConfig {

    @Bean
    public AiRunStatusDataMapper airunsstatusDataMapper() {
        return new AiRunStatusDataMapper();
    }

    @Bean
    public AiRunStatusRepository airunsstatusRepository(AiRunStatusDbRepository repository, AiRunStatusDataMapper mapper) {
        return new AiRunStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiRunStatusUseCase registerAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new RegisterAiRunStatusUseCase(repository);
    }

    @Bean
    public GetAiRunStatusByIdUseCase getAiRunStatusByIdUseCase(AiRunStatusRepository repository) {
        return new GetAiRunStatusByIdUseCase(repository);
    }

    @Bean
    public ListAiRunStatusUseCase listAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new ListAiRunStatusUseCase(repository);
    }

    @Bean
    public UpdateAiRunStatusUseCase updateAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new UpdateAiRunStatusUseCase(repository);
    }

    @Bean
    public DeleteAiRunStatusUseCase deleteAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new DeleteAiRunStatusUseCase(repository);
    }
}
