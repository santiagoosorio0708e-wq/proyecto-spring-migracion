package com.backintro.infrastructure.country.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.country.usecase.*;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryDataMapper;
import com.backintro.infrastructure.country.adapters.out.persistence.repositories.*;

@Configuration
public class CountryAppConfig {

    @Bean
    public CountryDataMapper countryDataMapper() {
        return new CountryDataMapper();
    }

    @Bean
    public CountryRepository countryRepository(CountryDbRepository repository, CountryDataMapper mapper) {
        return new CountryRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCountryUseCase registerCountryUseCase(CountryRepository repository) {
        return new RegisterCountryUseCase(repository);
    }

    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryRepository repository) {
        return new GetCountryByIdUseCase(repository);
    }

    @Bean
    public ListCountryUseCase listCountryUseCase(CountryRepository repository) {
        return new ListCountryUseCase(repository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository repository) {
        return new UpdateCountryUseCase(repository);
    }

    @Bean
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository repository) {
        return new DeleteCountryUseCase(repository);
    }
}
