package com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers;

import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactEntity;

public class PatientContactDataMapper {
    public PatientContactEntity toJpa(PatientContact aggregate) {
        if (aggregate == null) return null;
        return new PatientContactEntity(aggregate.id().value(), aggregate.contactId(), aggregate.patientId(), aggregate.isPrimaryContact(), aggregate.isEmergencyContact(), aggregate.relationshipTypeId());
    }

    public PatientContact toDomain(PatientContactEntity entityObj) {
        if (entityObj == null) return null;
        return PatientContact.restore(new PatientContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getPatientId(), entityObj.getIsPrimaryContact(), entityObj.getIsEmergencyContact(), entityObj.getRelationshipTypeId());
    }
}
