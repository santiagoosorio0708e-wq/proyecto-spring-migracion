package com.backintro.infrastructure.diagnosticsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.diagnosticsystem.usecase.*;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.mappers.DiagnosticSystemDataMapper;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.repositories.*;

@Configuration
public class DiagnosticSystemAppConfig {

    @Bean
    public DiagnosticSystemDataMapper diagnosticsystemDataMapper() {
        return new DiagnosticSystemDataMapper();
    }

    @Bean
    public DiagnosticSystemRepository diagnosticsystemRepository(DiagnosticSystemDbRepository repository, DiagnosticSystemDataMapper mapper) {
        return new DiagnosticSystemRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterDiagnosticSystemUseCase registerDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new RegisterDiagnosticSystemUseCase(repository);
    }

    @Bean
    public GetDiagnosticSystemByIdUseCase getDiagnosticSystemByIdUseCase(DiagnosticSystemRepository repository) {
        return new GetDiagnosticSystemByIdUseCase(repository);
    }

    @Bean
    public ListDiagnosticSystemUseCase listDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new ListDiagnosticSystemUseCase(repository);
    }

    @Bean
    public UpdateDiagnosticSystemUseCase updateDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new UpdateDiagnosticSystemUseCase(repository);
    }

    @Bean
    public DeleteDiagnosticSystemUseCase deleteDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new DeleteDiagnosticSystemUseCase(repository);
    }
}
