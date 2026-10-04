CREATE TABLE IF NOT EXISTS relationship_types (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR(50) UNIQUE
);