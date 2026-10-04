CREATE TABLE IF NOT EXISTS chat_messages (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_id UUID,
    message_type_id UUID,
    participant_id UUID,
    content TEXT,
    metadata JSONB,
    created_at TIMESTAMP
);

ALTER TABLE chat_messages ADD CONSTRAINT fk_chat_messages_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations(id);

ALTER TABLE chat_messages ADD CONSTRAINT fk_chat_messages_message_type_id FOREIGN KEY (message_type_id) REFERENCES message_types(id);

ALTER TABLE chat_messages ADD CONSTRAINT fk_chat_messages_participant_id FOREIGN KEY (participant_id) REFERENCES chat_participants(id);
