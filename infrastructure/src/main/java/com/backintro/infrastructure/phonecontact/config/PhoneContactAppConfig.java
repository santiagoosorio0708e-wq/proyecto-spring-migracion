package com.backintro.infrastructure.phonecontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.phonecontact.usecase.*;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactDataMapper;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories.*;

@Configuration
public class PhoneContactAppConfig {

    @Bean
    public PhoneContactDataMapper phonecontactDataMapper() {
        return new PhoneContactDataMapper();
    }

    @Bean
    public PhoneContactRepository phonecontactRepository(PhoneContactDbRepository repository, PhoneContactDataMapper mapper) {
        return new PhoneContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPhoneContactUseCase registerPhoneContactUseCase(PhoneContactRepository repository) {
        return new RegisterPhoneContactUseCase(repository);
    }

    @Bean
    public GetPhoneContactByIdUseCase getPhoneContactByIdUseCase(PhoneContactRepository repository) {
        return new GetPhoneContactByIdUseCase(repository);
    }

    @Bean
    public ListPhoneContactUseCase listPhoneContactUseCase(PhoneContactRepository repository) {
        return new ListPhoneContactUseCase(repository);
    }

    @Bean
    public UpdatePhoneContactUseCase updatePhoneContactUseCase(PhoneContactRepository repository) {
        return new UpdatePhoneContactUseCase(repository);
    }

    @Bean
    public DeletePhoneContactUseCase deletePhoneContactUseCase(PhoneContactRepository repository) {
        return new DeletePhoneContactUseCase(repository);
    }
}
