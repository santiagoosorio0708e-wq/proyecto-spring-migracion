package com.backintro.infrastructure.emailcontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.emailcontact.usecase.*;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactDataMapper;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories.*;

@Configuration
public class EmailContactAppConfig {

    @Bean
    public EmailContactDataMapper emailcontactDataMapper() {
        return new EmailContactDataMapper();
    }

    @Bean
    public EmailContactRepository emailcontactRepository(EmailContactDbRepository repository, EmailContactDataMapper mapper) {
        return new EmailContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEmailContactUseCase registerEmailContactUseCase(EmailContactRepository repository) {
        return new RegisterEmailContactUseCase(repository);
    }

    @Bean
    public GetEmailContactByIdUseCase getEmailContactByIdUseCase(EmailContactRepository repository) {
        return new GetEmailContactByIdUseCase(repository);
    }

    @Bean
    public ListEmailContactUseCase listEmailContactUseCase(EmailContactRepository repository) {
        return new ListEmailContactUseCase(repository);
    }

    @Bean
    public UpdateEmailContactUseCase updateEmailContactUseCase(EmailContactRepository repository) {
        return new UpdateEmailContactUseCase(repository);
    }

    @Bean
    public DeleteEmailContactUseCase deleteEmailContactUseCase(EmailContactRepository repository) {
        return new DeleteEmailContactUseCase(repository);
    }
}
