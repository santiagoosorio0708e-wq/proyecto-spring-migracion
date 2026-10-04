package com.backintro.infrastructure.contact.adapters.out.persistence.mappers;

import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactEntity;

public class ContactDataMapper {
    public ContactEntity toJpa(Contact aggregate) {
        if (aggregate == null) return null;
        return new ContactEntity(aggregate.id().value(), aggregate.fullName(), aggregate.email(), aggregate.notes(), aggregate.cityId(), aggregate.createdAt(), aggregate.createdBy(), aggregate.updatedAt(), aggregate.updatedBy());
    }

    public Contact toDomain(ContactEntity entityObj) {
        if (entityObj == null) return null;
        return Contact.restore(new ContactId(entityObj.getId()), entityObj.getFullName(), entityObj.getEmail(), entityObj.getNotes(), entityObj.getCityId(), entityObj.getCreatedAt(), entityObj.getCreatedBy(), entityObj.getUpdatedAt(), entityObj.getUpdatedBy());
    }
}
