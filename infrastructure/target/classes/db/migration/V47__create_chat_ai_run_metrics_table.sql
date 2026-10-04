CREATE TABLE IF NOT EXISTS chat_ai_run_metrics (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    ai_run_id UUID,
    prompt_tokens INTEGER,
    completion_tokens INTEGER,
    total_tokens INTEGER,
    cost DECIMAL(10,6),
    created_at TIMESTAMP
);

ALTER TABLE chat_ai_run_metrics ADD CONSTRAINT fk_chat_ai_run_metrics_ai_run_id FOREIGN KEY (ai_run_id) REFERENCES chat_ai_runs(id);
