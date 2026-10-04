package com.backintro.infrastructure.relationshiptype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.relationshiptype.usecase.*;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypeDataMapper;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories.*;

@Configuration
public class RelationshipTypeAppConfig {

    @Bean
    public RelationshipTypeDataMapper relationshiptypeDataMapper() {
        return new RelationshipTypeDataMapper();
    }

    @Bean
    public RelationshipTypeRepository relationshiptypeRepository(RelationshipTypeDbRepository repository, RelationshipTypeDataMapper mapper) {
        return new RelationshipTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRelationshipTypeUseCase registerRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new RegisterRelationshipTypeUseCase(repository);
    }

    @Bean
    public GetRelationshipTypeByIdUseCase getRelationshipTypeByIdUseCase(RelationshipTypeRepository repository) {
        return new GetRelationshipTypeByIdUseCase(repository);
    }

    @Bean
    public ListRelationshipTypeUseCase listRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new ListRelationshipTypeUseCase(repository);
    }

    @Bean
    public UpdateRelationshipTypeUseCase updateRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new UpdateRelationshipTypeUseCase(repository);
    }

    @Bean
    public DeleteRelationshipTypeUseCase deleteRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new DeleteRelationshipTypeUseCase(repository);
    }
}
