CREATE TABLE IF NOT EXISTS provider_models_ai (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_provider_ai VARCHAR(100),
    razon_social VARCHAR(255),
    sitio_web TEXT,
    is_active BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);