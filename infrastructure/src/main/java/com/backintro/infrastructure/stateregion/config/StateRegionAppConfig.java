package com.backintro.infrastructure.stateregion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.stateregion.usecase.*;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionDataMapper;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories.*;

@Configuration
public class StateRegionAppConfig {

    @Bean
    public StateRegionDataMapper stateregionDataMapper() {
        return new StateRegionDataMapper();
    }

    @Bean
    public StateRegionRepository stateregionRepository(StateRegionDbRepository repository, StateRegionDataMapper mapper) {
        return new StateRegionRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterStateRegionUseCase registerStateRegionUseCase(StateRegionRepository repository) {
        return new RegisterStateRegionUseCase(repository);
    }

    @Bean
    public GetStateRegionByIdUseCase getStateRegionByIdUseCase(StateRegionRepository repository) {
        return new GetStateRegionByIdUseCase(repository);
    }

    @Bean
    public ListStateRegionUseCase listStateRegionUseCase(StateRegionRepository repository) {
        return new ListStateRegionUseCase(repository);
    }

    @Bean
    public UpdateStateRegionUseCase updateStateRegionUseCase(StateRegionRepository repository) {
        return new UpdateStateRegionUseCase(repository);
    }

    @Bean
    public DeleteStateRegionUseCase deleteStateRegionUseCase(StateRegionRepository repository) {
        return new DeleteStateRegionUseCase(repository);
    }
}
