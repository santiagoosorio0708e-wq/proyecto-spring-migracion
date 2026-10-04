package com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamEntity;

public interface MentalStatusExamDbRepository extends DbRepository<MentalStatusExamEntity, UUID> {
}
