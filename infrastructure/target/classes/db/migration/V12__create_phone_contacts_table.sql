CREATE TABLE IF NOT EXISTS phone_contacts (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    contact_id UUID,
    phone VARCHAR(30),
    notes TEXT,
    column1 VARCHAR(255),
    column2 VARCHAR(255)
);

ALTER TABLE phone_contacts ADD CONSTRAINT fk_phone_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts(id);
