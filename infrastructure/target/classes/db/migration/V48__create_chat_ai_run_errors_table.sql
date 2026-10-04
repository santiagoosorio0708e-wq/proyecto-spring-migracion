CREATE TABLE IF NOT EXISTS chat_ai_run_errors (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    ai_run_id UUID,
    error_message TEXT,
    error_code VARCHAR(80),
    provider_error_id VARCHAR(120),
    created_at TIMESTAMP
);

ALTER TABLE chat_ai_run_errors ADD CONSTRAINT fk_chat_ai_run_errors_ai_run_id FOREIGN KEY (ai_run_id) REFERENCES chat_ai_runs(id);
