package com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionEntity;

public class StateRegionDataMapper {
    public StateRegionEntity toJpa(StateRegion aggregate) {
        if (aggregate == null) return null;
        return new StateRegionEntity(aggregate.id().value(), aggregate.nameRegion(), aggregate.codeRegion(), aggregate.description(), aggregate.isActive(), aggregate.countryId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public StateRegion toDomain(StateRegionEntity entityObj) {
        if (entityObj == null) return null;
        return StateRegion.restore(new StateRegionId(entityObj.getId()), entityObj.getNameRegion(), entityObj.getCodeRegion(), entityObj.getDescription(), entityObj.getIsActive(), entityObj.getCountryId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
