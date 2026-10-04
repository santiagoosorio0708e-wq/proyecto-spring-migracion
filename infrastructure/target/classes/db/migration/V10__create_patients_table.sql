CREATE TABLE IF NOT EXISTS patients (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    document_type_id UUID,
    document_number VARCHAR(30),
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    second_last_name VARCHAR(50),
    birth_date DATE,
    biological_sex_id UUID,
    gender_identity UUID,
    email VARCHAR(150) UNIQUE,
    phone VARCHAR(30),
    address VARCHAR(250),
    active BOOLEAN,
    created_at TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID,
    city_id UUID
);

ALTER TABLE patients ADD CONSTRAINT fk_patients_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_types(id);

ALTER TABLE patients ADD CONSTRAINT fk_patients_biological_sex_id FOREIGN KEY (biological_sex_id) REFERENCES genders(id);

ALTER TABLE patients ADD CONSTRAINT fk_patients_gender_identity FOREIGN KEY (gender_identity) REFERENCES genders(id);

ALTER TABLE patients ADD CONSTRAINT fk_patients_created_by FOREIGN KEY (created_by) REFERENCES professionals(id);

ALTER TABLE patients ADD CONSTRAINT fk_patients_updated_by FOREIGN KEY (updated_by) REFERENCES professionals(id);

ALTER TABLE patients ADD CONSTRAINT fk_patients_city_id FOREIGN KEY (city_id) REFERENCES city_municipalities(id);
