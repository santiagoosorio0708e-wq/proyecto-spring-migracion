CREATE TABLE IF NOT EXISTS studies (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(40),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);