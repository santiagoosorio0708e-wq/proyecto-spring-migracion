package com.backintro.infrastructure.risklevel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.risklevel.usecase.*;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.mappers.RiskLevelDataMapper;
import com.backintro.infrastructure.risklevel.adapters.out.persistence.repositories.*;

@Configuration
public class RiskLevelAppConfig {

    @Bean
    public RiskLevelDataMapper risklevelDataMapper() {
        return new RiskLevelDataMapper();
    }

    @Bean
    public RiskLevelRepository risklevelRepository(RiskLevelDbRepository repository, RiskLevelDataMapper mapper) {
        return new RiskLevelRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRiskLevelUseCase registerRiskLevelUseCase(RiskLevelRepository repository) {
        return new RegisterRiskLevelUseCase(repository);
    }

    @Bean
    public GetRiskLevelByIdUseCase getRiskLevelByIdUseCase(RiskLevelRepository repository) {
        return new GetRiskLevelByIdUseCase(repository);
    }

    @Bean
    public ListRiskLevelUseCase listRiskLevelUseCase(RiskLevelRepository repository) {
        return new ListRiskLevelUseCase(repository);
    }

    @Bean
    public UpdateRiskLevelUseCase updateRiskLevelUseCase(RiskLevelRepository repository) {
        return new UpdateRiskLevelUseCase(repository);
    }

    @Bean
    public DeleteRiskLevelUseCase deleteRiskLevelUseCase(RiskLevelRepository repository) {
        return new DeleteRiskLevelUseCase(repository);
    }
}
