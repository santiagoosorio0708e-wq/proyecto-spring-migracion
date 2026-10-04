package com.backintro.infrastructure.providermodelsai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.providermodelsai.usecase.*;
import com.backintro.domain.providermodelsai.port.repository.ProviderModelAiRepository;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.mappers.ProviderModelAiDataMapper;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.repositories.*;

@Configuration
public class ProviderModelAiAppConfig {

    @Bean
    public ProviderModelAiDataMapper providermodelsaiDataMapper() {
        return new ProviderModelAiDataMapper();
    }

    @Bean
    public ProviderModelAiRepository providermodelsaiRepository(ProviderModelAiDbRepository repository, ProviderModelAiDataMapper mapper) {
        return new ProviderModelAiRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProviderModelAiUseCase registerProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new RegisterProviderModelAiUseCase(repository);
    }

    @Bean
    public GetProviderModelAiByIdUseCase getProviderModelAiByIdUseCase(ProviderModelAiRepository repository) {
        return new GetProviderModelAiByIdUseCase(repository);
    }

    @Bean
    public ListProviderModelAiUseCase listProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new ListProviderModelAiUseCase(repository);
    }

    @Bean
    public UpdateProviderModelAiUseCase updateProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new UpdateProviderModelAiUseCase(repository);
    }

    @Bean
    public DeleteProviderModelAiUseCase deleteProviderModelAiUseCase(ProviderModelAiRepository repository) {
        return new DeleteProviderModelAiUseCase(repository);
    }
}
