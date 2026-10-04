CREATE TABLE IF NOT EXISTS email_contacts (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contact_id UUID,
    email VARCHAR(150) UNIQUE,
    notes TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE email_contacts ADD CONSTRAINT fk_email_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts(id);
