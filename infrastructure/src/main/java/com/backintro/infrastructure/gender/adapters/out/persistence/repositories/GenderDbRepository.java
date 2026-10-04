package com.backintro.infrastructure.gender.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.gender.adapters.out.persistence.entity.GenderEntity;

public interface GenderDbRepository extends DbRepository<GenderEntity, UUID> {
}
