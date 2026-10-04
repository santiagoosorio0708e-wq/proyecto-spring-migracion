CREATE TABLE IF NOT EXISTS chat_conversation_ai_settings (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_id UUID,
    ai_enabled BOOLEAN,
    default_model_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE chat_conversation_ai_settings ADD CONSTRAINT fk_chat_conversation_ai_settings_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations(id);

ALTER TABLE chat_conversation_ai_settings ADD CONSTRAINT fk_chat_conversation_ai_settings_default_model_id FOREIGN KEY (default_model_id) REFERENCES ai_models(id);
