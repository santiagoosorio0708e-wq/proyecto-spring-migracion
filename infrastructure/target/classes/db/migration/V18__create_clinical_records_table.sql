CREATE TABLE IF NOT EXISTS clinical_records (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    patient_id UUID,
    creation_date TIMESTAMP,
    record_number VARCHAR(50),
    opened_at TIMESTAMP,
    closed_at TIMESTAMP,
    status_id UUID,
    created_at TIMESTAMP,
    created_by UUID
);

ALTER TABLE clinical_records ADD CONSTRAINT fk_clinical_records_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id);

ALTER TABLE clinical_records ADD CONSTRAINT fk_clinical_records_status_id FOREIGN KEY (status_id) REFERENCES clinical_record_statuses(id);

ALTER TABLE clinical_records ADD CONSTRAINT fk_clinical_records_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);
