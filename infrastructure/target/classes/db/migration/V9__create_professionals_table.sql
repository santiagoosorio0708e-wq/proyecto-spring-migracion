CREATE TABLE IF NOT EXISTS professionals (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    document_type_id UUID,
    document_number VARCHAR(30) UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    professional_type UUID,
    license_number VARCHAR(100) UNIQUE,
    active BOOLEAN,
    city_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE professionals ADD CONSTRAINT fk_professionals_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_types(id);

ALTER TABLE professionals ADD CONSTRAINT fk_professionals_professional_type FOREIGN KEY (professional_type) REFERENCES professional_types(id);

ALTER TABLE professionals ADD CONSTRAINT fk_professionals_city_id FOREIGN KEY (city_id) REFERENCES city_municipalities(id);
