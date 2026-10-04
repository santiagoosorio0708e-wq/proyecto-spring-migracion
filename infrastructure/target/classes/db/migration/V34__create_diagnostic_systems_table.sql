CREATE TABLE IF NOT EXISTS diagnostic_systems (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(20) UNIQUE,
    name VARCHAR(50),
    active BOOLEAN,
    version VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);