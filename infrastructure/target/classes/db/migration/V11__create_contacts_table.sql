CREATE TABLE IF NOT EXISTS contacts (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name VARCHAR(200),
    email VARCHAR(150),
    notes TEXT,
    city_id UUID,
    created_at TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID
);

ALTER TABLE contacts ADD CONSTRAINT fk_contacts_city_id FOREIGN KEY (city_id) REFERENCES city_municipalities(id);

ALTER TABLE contacts ADD CONSTRAINT fk_contacts_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);

ALTER TABLE contacts ADD CONSTRAINT fk_contacts_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);
