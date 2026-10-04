CREATE TABLE IF NOT EXISTS encounters (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    clinical_record_id UUID,
    professional_id UUID,
    encounter_type_id UUID,
    started_at TIMESTAMP,
    ended_at TIMESTAMP,
    reason_for_visit TEXT,
    current_condition TEXT,
    modality_id UUID,
    status_id UUID,
    created_at TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID
);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_clinical_record_id FOREIGN KEY (clinical_record_id) REFERENCES clinical_records(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_encounter_type_id FOREIGN KEY (encounter_type_id) REFERENCES encounter_types(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_modality_id FOREIGN KEY (modality_id) REFERENCES encounter_modalities(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_status_id FOREIGN KEY (status_id) REFERENCES encounter_statuses(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);

ALTER TABLE encounters ADD CONSTRAINT fk_encounters_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);
