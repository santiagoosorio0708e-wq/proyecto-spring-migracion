CREATE TABLE IF NOT EXISTS chat_ai_runs (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_id UUID,
    message_id UUID,
    model_id UUID,
    ai_run_status_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE chat_ai_runs ADD CONSTRAINT fk_chat_ai_runs_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations(id);

ALTER TABLE chat_ai_runs ADD CONSTRAINT fk_chat_ai_runs_message_id FOREIGN KEY (message_id) REFERENCES chat_messages(id);

ALTER TABLE chat_ai_runs ADD CONSTRAINT fk_chat_ai_runs_model_id FOREIGN KEY (model_id) REFERENCES ai_models(id);

ALTER TABLE chat_ai_runs ADD CONSTRAINT fk_chat_ai_runs_ai_run_status_id FOREIGN KEY (ai_run_status_id) REFERENCES ai_runs_statuses(id);
