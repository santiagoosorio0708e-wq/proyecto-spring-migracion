CREATE TABLE IF NOT EXISTS priorities (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_priority VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);