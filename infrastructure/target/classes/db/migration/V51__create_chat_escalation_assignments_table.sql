CREATE TABLE IF NOT EXISTS chat_escalation_assignments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    escalation_id UUID,
    professional_id UUID,
    assigned_at TIMESTAMP
);

ALTER TABLE chat_escalation_assignments ADD CONSTRAINT fk_chat_escalation_assignments_escalation_id FOREIGN KEY (escalation_id) REFERENCES chat_escalations(id);

ALTER TABLE chat_escalation_assignments ADD CONSTRAINT fk_chat_escalation_assignments_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);
