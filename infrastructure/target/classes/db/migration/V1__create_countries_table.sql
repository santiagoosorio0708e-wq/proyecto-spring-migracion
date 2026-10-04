CREATE TABLE IF NOT EXISTS countries (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_country VARCHAR(50),
    code_country VARCHAR(10),
    description VARCHAR(100),
    is_active BOOLEAN,
    telephone_prefix VARCHAR(5),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);