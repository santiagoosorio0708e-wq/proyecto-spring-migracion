package com.backintro.infrastructure.empresa.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaEntity;

public interface SpringDataEmpresaDbRepository extends DbRepository<EmpresaEntity, UUID> {
}
