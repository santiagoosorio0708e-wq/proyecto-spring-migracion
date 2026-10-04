CREATE TABLE IF NOT EXISTS treatment_plans (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    encounter_id UUID,
    professional_id UUID,
    title VARCHAR(200),
    description TEXT,
    start_date DATE,
    end_date DATE,
    treatment_status_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE treatment_plans ADD CONSTRAINT fk_treatment_plans_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters(id);

ALTER TABLE treatment_plans ADD CONSTRAINT fk_treatment_plans_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);

ALTER TABLE treatment_plans ADD CONSTRAINT fk_treatment_plans_treatment_status_id FOREIGN KEY (treatment_status_id) REFERENCES treatment_statuses(id);
