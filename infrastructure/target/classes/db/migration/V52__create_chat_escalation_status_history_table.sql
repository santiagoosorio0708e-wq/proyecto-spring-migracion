CREATE TABLE IF NOT EXISTS chat_escalation_status_history (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    escalation_id UUID,
    escalation_status_id UUID,
    created_at TIMESTAMP,
    changed_at TIMESTAMP
);

ALTER TABLE chat_escalation_status_history ADD CONSTRAINT fk_chat_escalation_status_history_escalation_id FOREIGN KEY (escalation_id) REFERENCES chat_escalations(id);

ALTER TABLE chat_escalation_status_history ADD CONSTRAINT fk_chat_escalation_status_history_escalation_status_id FOREIGN KEY (escalation_status_id) REFERENCES escalations_statuses(id);
