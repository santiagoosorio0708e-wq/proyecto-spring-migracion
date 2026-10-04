package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers;

import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityEntity;

public class CityMunicipalityDataMapper {
    public CityMunicipalityEntity toJpa(CityMunicipality aggregate) {
        if (aggregate == null) return null;
        return new CityMunicipalityEntity(aggregate.id().value(), aggregate.nameCity(), aggregate.codeCiti(), aggregate.description(), aggregate.isActive(), aggregate.regionId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public CityMunicipality toDomain(CityMunicipalityEntity entityObj) {
        if (entityObj == null) return null;
        return CityMunicipality.restore(new CityMunicipalityId(entityObj.getId()), entityObj.getNameCity(), entityObj.getCodeCiti(), entityObj.getDescription(), entityObj.getIsActive(), entityObj.getRegionId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
