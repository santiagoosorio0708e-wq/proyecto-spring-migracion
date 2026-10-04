package com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeEntity;

public interface SpringDataProfessionalTypeDbRepository extends DbRepository<ProfessionalTypeEntity, UUID> {
}
