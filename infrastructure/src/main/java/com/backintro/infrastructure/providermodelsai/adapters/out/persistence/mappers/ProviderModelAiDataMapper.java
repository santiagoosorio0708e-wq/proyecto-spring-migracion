package com.backintro.infrastructure.providermodelsai.adapters.out.persistence.mappers;

import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;
import com.backintro.infrastructure.providermodelsai.adapters.out.persistence.entity.ProviderModelAiEntity;

public class ProviderModelAiDataMapper {
    public ProviderModelAiEntity toJpa(ProviderModelAi aggregate) {
        if (aggregate == null) return null;
        return new ProviderModelAiEntity(aggregate.id().value(), aggregate.nameProviderAi(), aggregate.razonSocial(), aggregate.sitioWeb(), aggregate.isActive(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public ProviderModelAi toDomain(ProviderModelAiEntity entityObj) {
        if (entityObj == null) return null;
        return ProviderModelAi.restore(new ProviderModelAiId(entityObj.getId()), entityObj.getNameProviderAi(), entityObj.getRazonSocial(), entityObj.getSitioWeb(), entityObj.getIsActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
