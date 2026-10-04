package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.DbRepository;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityEntity;

public interface CityMunicipalityDbRepository extends DbRepository<CityMunicipalityEntity, UUID> {
}
