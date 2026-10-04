CREATE TABLE IF NOT EXISTS clinical_notes (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    encounter_id UUID,
    professional_id UUID,
    subjective TEXT,
    objective TEXT,
    assessment TEXT,
    plan TEXT,
    additional_notes TEXT,
    signed_at TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE clinical_notes ADD CONSTRAINT fk_clinical_notes_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters(id);

ALTER TABLE clinical_notes ADD CONSTRAINT fk_clinical_notes_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);
