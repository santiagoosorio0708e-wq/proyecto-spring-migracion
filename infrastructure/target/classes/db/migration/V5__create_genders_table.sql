CREATE TABLE IF NOT EXISTS genders (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR(50) UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);