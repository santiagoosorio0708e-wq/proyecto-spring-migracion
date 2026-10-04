CREATE TABLE IF NOT EXISTS consent_types (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(20) UNIQUE,
    name VARCHAR(50),
    active BOOLEAN,
    description TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);