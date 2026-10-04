CREATE TABLE IF NOT EXISTS chat_participants (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    conversation_id UUID,
    participant_type_id UUID,
    patient_id UUID,
    professional_id UUID,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE chat_participants ADD CONSTRAINT fk_chat_participants_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations(id);

ALTER TABLE chat_participants ADD CONSTRAINT fk_chat_participants_participant_type_id FOREIGN KEY (participant_type_id) REFERENCES sender_types(id);

ALTER TABLE chat_participants ADD CONSTRAINT fk_chat_participants_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id);

ALTER TABLE chat_participants ADD CONSTRAINT fk_chat_participants_professional_id FOREIGN KEY (professional_id) REFERENCES professionals(id);
