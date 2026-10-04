package com.backintro.infrastructure.country.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryEntity;

public interface CountryDbRepository extends DbRepository<CountryEntity, UUID> {
}
