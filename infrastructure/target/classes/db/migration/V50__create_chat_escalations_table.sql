CREATE TABLE IF NOT EXISTS chat_escalations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_id UUID,
    status_id UUID,
    from_ai BOOLEAN,
    reason TEXT,
    created_at TIMESTAMP
);

ALTER TABLE chat_escalations ADD CONSTRAINT fk_chat_escalations_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations(id);

ALTER TABLE chat_escalations ADD CONSTRAINT fk_chat_escalations_status_id FOREIGN KEY (status_id) REFERENCES escalations_statuses(id);
