package com.backintro.infrastructure.professional.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.entity.ProfessionalEntity;

public interface ProfessionalDbRepository extends DbRepository<ProfessionalEntity, UUID> {
}
