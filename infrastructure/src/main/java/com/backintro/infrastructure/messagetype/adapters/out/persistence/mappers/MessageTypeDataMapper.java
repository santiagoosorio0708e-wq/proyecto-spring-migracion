package com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers;

import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeEntity;

public class MessageTypeDataMapper {
    public MessageTypeEntity toJpa(MessageType aggregate) {
        if (aggregate == null) return null;
        return new MessageTypeEntity(aggregate.id().value(), aggregate.nameType(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public MessageType toDomain(MessageTypeEntity entityObj) {
        if (entityObj == null) return null;
        return MessageType.restore(new MessageTypeId(entityObj.getId()), entityObj.getNameType(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
