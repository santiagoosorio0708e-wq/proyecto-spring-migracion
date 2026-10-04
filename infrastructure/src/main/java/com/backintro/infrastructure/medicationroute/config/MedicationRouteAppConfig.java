package com.backintro.infrastructure.medicationroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.medicationroute.usecase.*;
import com.backintro.domain.medicationroute.port.repository.MedicationRouteRepository;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.mappers.MedicationRouteDataMapper;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.repositories.*;

@Configuration
public class MedicationRouteAppConfig {

    @Bean
    public MedicationRouteDataMapper medicationrouteDataMapper() {
        return new MedicationRouteDataMapper();
    }

    @Bean
    public MedicationRouteRepository medicationrouteRepository(MedicationRouteDbRepository repository, MedicationRouteDataMapper mapper) {
        return new MedicationRouteRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterMedicationRouteUseCase registerMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new RegisterMedicationRouteUseCase(repository);
    }

    @Bean
    public GetMedicationRouteByIdUseCase getMedicationRouteByIdUseCase(MedicationRouteRepository repository) {
        return new GetMedicationRouteByIdUseCase(repository);
    }

    @Bean
    public ListMedicationRouteUseCase listMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new ListMedicationRouteUseCase(repository);
    }

    @Bean
    public UpdateMedicationRouteUseCase updateMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new UpdateMedicationRouteUseCase(repository);
    }

    @Bean
    public DeleteMedicationRouteUseCase deleteMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new DeleteMedicationRouteUseCase(repository);
    }
}
