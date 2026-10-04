CREATE TABLE IF NOT EXISTS risk_assessments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    encounter_id UUID,
    risk_level_id UUID,
    suicidal_ideation BOOLEAN,
    suicide_plan BOOLEAN,
    suicide_intent BOOLEAN,
    self_harm BOOLEAN,
    harm_to_others BOOLEAN,
    risk_factors TEXT,
    protective_factors TEXT,
    clinical_actions TEXT,
    observations TEXT,
    assessed_at TIMESTAMP,
    assessed_by UUID
);

ALTER TABLE risk_assessments ADD CONSTRAINT fk_risk_assessments_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters(id);

ALTER TABLE risk_assessments ADD CONSTRAINT fk_risk_assessments_risk_level_id FOREIGN KEY (risk_level_id) REFERENCES risk_levels(id);

ALTER TABLE risk_assessments ADD CONSTRAINT fk_risk_assessments_assessed_by FOREIGN KEY (assessed_by) REFERENCES professionals(id);
