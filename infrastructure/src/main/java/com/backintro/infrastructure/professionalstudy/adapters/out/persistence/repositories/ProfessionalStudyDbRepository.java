package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyEntity;

public interface ProfessionalStudyDbRepository extends DbRepository<ProfessionalStudyEntity, UUID> {
}
