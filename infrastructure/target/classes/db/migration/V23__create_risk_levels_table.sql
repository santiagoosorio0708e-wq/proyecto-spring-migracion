CREATE TABLE IF NOT EXISTS risk_levels (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(20) UNIQUE,
    name VARCHAR(50),
    active BOOLEAN,
    severity INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);