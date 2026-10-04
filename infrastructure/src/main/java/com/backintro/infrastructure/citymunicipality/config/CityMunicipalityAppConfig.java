package com.backintro.infrastructure.citymunicipality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.citymunicipality.usecase.*;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityDataMapper;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.repositories.*;

@Configuration
public class CityMunicipalityAppConfig {

    @Bean
    public CityMunicipalityDataMapper citymunicipalityDataMapper() {
        return new CityMunicipalityDataMapper();
    }

    @Bean
    public CityMunicipalityRepository citymunicipalityRepository(CityMunicipalityDbRepository repository, CityMunicipalityDataMapper mapper) {
        return new CityMunicipalityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCityMunicipalityUseCase registerCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new RegisterCityMunicipalityUseCase(repository);
    }

    @Bean
    public GetCityMunicipalityByIdUseCase getCityMunicipalityByIdUseCase(CityMunicipalityRepository repository) {
        return new GetCityMunicipalityByIdUseCase(repository);
    }

    @Bean
    public ListCityMunicipalityUseCase listCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new ListCityMunicipalityUseCase(repository);
    }

    @Bean
    public UpdateCityMunicipalityUseCase updateCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new UpdateCityMunicipalityUseCase(repository);
    }

    @Bean
    public DeleteCityMunicipalityUseCase deleteCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new DeleteCityMunicipalityUseCase(repository);
    }
}
