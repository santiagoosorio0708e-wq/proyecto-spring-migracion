package com.backintro.infrastructure.mentalstatusexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.mentalstatusexam.usecase.*;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.mappers.MentalStatusExamDataMapper;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.repositories.*;

@Configuration
public class MentalStatusExamAppConfig {

    @Bean
    public MentalStatusExamDataMapper mentalstatusexamDataMapper() {
        return new MentalStatusExamDataMapper();
    }

    @Bean
    public MentalStatusExamRepository mentalstatusexamRepository(MentalStatusExamDbRepository repository, MentalStatusExamDataMapper mapper) {
        return new MentalStatusExamRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterMentalStatusExamUseCase registerMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        return new RegisterMentalStatusExamUseCase(repository);
    }

    @Bean
    public GetMentalStatusExamByIdUseCase getMentalStatusExamByIdUseCase(MentalStatusExamRepository repository) {
        return new GetMentalStatusExamByIdUseCase(repository);
    }

    @Bean
    public ListMentalStatusExamUseCase listMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        return new ListMentalStatusExamUseCase(repository);
    }

    @Bean
    public UpdateMentalStatusExamUseCase updateMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        return new UpdateMentalStatusExamUseCase(repository);
    }

    @Bean
    public DeleteMentalStatusExamUseCase deleteMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        return new DeleteMentalStatusExamUseCase(repository);
    }
}
