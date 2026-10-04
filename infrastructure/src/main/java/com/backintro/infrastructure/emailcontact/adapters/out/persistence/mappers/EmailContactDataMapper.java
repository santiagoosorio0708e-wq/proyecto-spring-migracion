package com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactEntity;

public class EmailContactDataMapper {
    public EmailContactEntity toJpa(EmailContact aggregate) {
        if (aggregate == null) return null;
        return new EmailContactEntity(aggregate.id().value(), aggregate.contactId(), aggregate.email(), aggregate.notes(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EmailContact toDomain(EmailContactEntity entityObj) {
        if (entityObj == null) return null;
        return EmailContact.restore(new EmailContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getEmail(), entityObj.getNotes(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
