CREATE TABLE IF NOT EXISTS mental_status_exams (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    encounter_id UUID,
    appearance TEXT,
    behavior TEXT,
    attitude TEXT,
    consciousness TEXT,
    orientation TEXT,
    attention TEXT,
    memory TEXT,
    speech TEXT,
    mood TEXT,
    affect TEXT,
    thought_process TEXT,
    thought_content TEXT,
    perception TEXT,
    judgment TEXT,
    insight TEXT,
    psychomotor_activity TEXT,
    observations TEXT,
    created_at TIMESTAMP,
    created_by UUID
);

ALTER TABLE mental_status_exams ADD CONSTRAINT fk_mental_status_exams_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters(id);

ALTER TABLE mental_status_exams ADD CONSTRAINT fk_mental_status_exams_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);
