CREATE TABLE IF NOT EXISTS state_regions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_region VARCHAR(50),
    code_region VARCHAR(10),
    description VARCHAR(100),
    is_active BOOLEAN,
    country_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE state_regions ADD CONSTRAINT fk_state_regions_country_id FOREIGN KEY (country_id) REFERENCES countries(id);
