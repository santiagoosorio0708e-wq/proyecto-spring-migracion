package com.backintro.infrastructure.priority.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.priority.usecase.*;
import com.backintro.domain.priority.port.repository.PriorityRepository;
import com.backintro.infrastructure.priority.adapters.out.persistence.mappers.PriorityDataMapper;
import com.backintro.infrastructure.priority.adapters.out.persistence.repositories.*;

@Configuration
public class PriorityAppConfig {

    @Bean
    public PriorityDataMapper priorityDataMapper() {
        return new PriorityDataMapper();
    }

    @Bean
    public PriorityRepository priorityRepository(PriorityDbRepository repository, PriorityDataMapper mapper) {
        return new PriorityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPriorityUseCase registerPriorityUseCase(PriorityRepository repository) {
        return new RegisterPriorityUseCase(repository);
    }

    @Bean
    public GetPriorityByIdUseCase getPriorityByIdUseCase(PriorityRepository repository) {
        return new GetPriorityByIdUseCase(repository);
    }

    @Bean
    public ListPriorityUseCase listPriorityUseCase(PriorityRepository repository) {
        return new ListPriorityUseCase(repository);
    }

    @Bean
    public UpdatePriorityUseCase updatePriorityUseCase(PriorityRepository repository) {
        return new UpdatePriorityUseCase(repository);
    }

    @Bean
    public DeletePriorityUseCase deletePriorityUseCase(PriorityRepository repository) {
        return new DeletePriorityUseCase(repository);
    }
}
