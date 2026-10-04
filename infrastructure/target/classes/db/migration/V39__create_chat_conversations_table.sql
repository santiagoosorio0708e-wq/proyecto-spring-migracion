CREATE TABLE IF NOT EXISTS chat_conversations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_status_id UUID,
    priority_id UUID,
    last_message_at TIMESTAMP,
    closed BOOLEAN,
    closed_at TIMESTAMP,
    closed_by UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE chat_conversations ADD CONSTRAINT fk_chat_conversations_conversation_status_id FOREIGN KEY (conversation_status_id) REFERENCES conversations_statuses(id);

ALTER TABLE chat_conversations ADD CONSTRAINT fk_chat_conversations_priority_id FOREIGN KEY (priority_id) REFERENCES priorities(id);

ALTER TABLE chat_conversations ADD CONSTRAINT fk_chat_conversations_closed_by FOREIGN KEY (closed_by) REFERENCES professionals(id);
