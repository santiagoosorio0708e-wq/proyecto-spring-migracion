CREATE TABLE IF NOT EXISTS ai_models (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    provider_model_id VARCHAR(50),
    name_model VARCHAR(100),
    model_key VARCHAR(120),
    input_token_price DECIMAL(12,6),
    output_token_price DECIMAL(12,6),
    max_tokens INTEGER,
    context_window INTEGER,
    is_active BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);