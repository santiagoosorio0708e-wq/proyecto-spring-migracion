CREATE TABLE IF NOT EXISTS city_municipalities (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name_city VARCHAR(50),
    code_citi VARCHAR(10),
    description VARCHAR(100),
    is_active BOOLEAN,
    region_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE city_municipalities ADD CONSTRAINT fk_city_municipalities_region_id FOREIGN KEY (region_id) REFERENCES state_regions(id);
