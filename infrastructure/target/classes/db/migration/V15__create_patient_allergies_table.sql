CREATE TABLE IF NOT EXISTS patient_allergies (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    patient_id UUID,
    substance VARCHAR(200),
    reaction TEXT,
    severity VARCHAR(20),
    active BOOLEAN,
    recorded_at TIMESTAMP,
    recorded_by UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE patient_allergies ADD CONSTRAINT fk_patient_allergies_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id);

ALTER TABLE patient_allergies ADD CONSTRAINT fk_patient_allergies_recorded_by FOREIGN KEY (recorded_by) REFERENCES professionals(id);
