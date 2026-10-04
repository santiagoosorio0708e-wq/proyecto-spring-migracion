package com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers;

import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactEntity;

public class PhoneContactDataMapper {
    public PhoneContactEntity toJpa(PhoneContact aggregate) {
        if (aggregate == null) return null;
        return new PhoneContactEntity(aggregate.id().value(), aggregate.contactId(), aggregate.phone(), aggregate.notes());
    }

    public PhoneContact toDomain(PhoneContactEntity entityObj) {
        if (entityObj == null) return null;
        return PhoneContact.restore(new PhoneContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getPhone(), entityObj.getNotes());
    }
}
