package com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.entity.DiagnosticSystemEntity;

public interface DiagnosticSystemDbRepository extends DbRepository<DiagnosticSystemEntity, UUID> {
}
