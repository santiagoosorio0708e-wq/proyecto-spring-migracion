CREATE TABLE IF NOT EXISTS professional_studies (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    study_id UUID,
    professional_id UUID,
    title VARCHAR(100),
    university VARCHAR(100),
    is_valid BOOLEAN,
    resolution_number VARCHAR(60),
    country_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE professional_studies ADD CONSTRAINT fk_professional_studies_study_id FOREIGN KEY (study_id) REFERENCES studies(id);

ALTER TABLE professional_studies ADD CONSTRAINT fk_professional_studies_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);

ALTER TABLE professional_studies ADD CONSTRAINT fk_professional_studies_country_id FOREIGN KEY (country_id) REFERENCES countries(id);
