package com.backintro.infrastructure.escalationsstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.escalationsstatus.usecase.*;
import com.backintro.domain.escalationsstatus.port.repository.EscalationStatusRepository;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.mappers.EscalationStatusDataMapper;
import com.backintro.infrastructure.escalationsstatus.adapters.out.persistence.repositories.*;

@Configuration
public class EscalationStatusAppConfig {

    @Bean
    public EscalationStatusDataMapper escalationsstatusDataMapper() {
        return new EscalationStatusDataMapper();
    }

    @Bean
    public EscalationStatusRepository escalationsstatusRepository(EscalationStatusDbRepository repository, EscalationStatusDataMapper mapper) {
        return new EscalationStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEscalationStatusUseCase registerEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new RegisterEscalationStatusUseCase(repository);
    }

    @Bean
    public GetEscalationStatusByIdUseCase getEscalationStatusByIdUseCase(EscalationStatusRepository repository) {
        return new GetEscalationStatusByIdUseCase(repository);
    }

    @Bean
    public ListEscalationStatusUseCase listEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new ListEscalationStatusUseCase(repository);
    }

    @Bean
    public UpdateEscalationStatusUseCase updateEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new UpdateEscalationStatusUseCase(repository);
    }

    @Bean
    public DeleteEscalationStatusUseCase deleteEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new DeleteEscalationStatusUseCase(repository);
    }
}
