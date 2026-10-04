package com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateChatParticipantReq(UUID conversationId, UUID participantTypeId, UUID patientId, UUID professionalId) {
}
