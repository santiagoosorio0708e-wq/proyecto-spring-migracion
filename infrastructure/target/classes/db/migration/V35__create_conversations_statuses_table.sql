CREATE TABLE IF NOT EXISTS conversations_statuses (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_status VARCHAR(50) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);