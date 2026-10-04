CREATE TABLE IF NOT EXISTS patient_contacts (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contact_id UUID,
    patient_id UUID,
    is_primary_contact BOOLEAN,
    is_emergency_contact BOOLEAN,
    relationship_type_id UUID
);

ALTER TABLE patient_contacts ADD CONSTRAINT fk_patient_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts(id);

ALTER TABLE patient_contacts ADD CONSTRAINT fk_patient_contacts_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id);

ALTER TABLE patient_contacts ADD CONSTRAINT fk_patient_contacts_relationship_type_id FOREIGN KEY (relationship_type_id) REFERENCES relationship_types(id);
