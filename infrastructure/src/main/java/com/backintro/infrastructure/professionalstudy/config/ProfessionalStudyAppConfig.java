package com.backintro.infrastructure.professionalstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.professionalstudy.usecase.*;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyDataMapper;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories.*;

@Configuration
public class ProfessionalStudyAppConfig {

    @Bean
    public ProfessionalStudyDataMapper professionalstudyDataMapper() {
        return new ProfessionalStudyDataMapper();
    }

    @Bean
    public ProfessionalStudyRepository professionalstudyRepository(ProfessionalStudyDbRepository repository, ProfessionalStudyDataMapper mapper) {
        return new ProfessionalStudyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalStudyUseCase registerProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        return new RegisterProfessionalStudyUseCase(repository);
    }

    @Bean
    public GetProfessionalStudyByIdUseCase getProfessionalStudyByIdUseCase(ProfessionalStudyRepository repository) {
        return new GetProfessionalStudyByIdUseCase(repository);
    }

    @Bean
    public ListProfessionalStudyUseCase listProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        return new ListProfessionalStudyUseCase(repository);
    }

    @Bean
    public UpdateProfessionalStudyUseCase updateProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        return new UpdateProfessionalStudyUseCase(repository);
    }

    @Bean
    public DeleteProfessionalStudyUseCase deleteProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        return new DeleteProfessionalStudyUseCase(repository);
    }
}
