CREATE TABLE IF NOT EXISTS message_types (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_type VARCHAR(50) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);