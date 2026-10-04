CREATE TABLE IF NOT EXISTS professional_types (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(40) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);