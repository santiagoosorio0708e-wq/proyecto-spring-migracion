package com.backintro.infrastructure.emailcontact.adapters.in.rest.dtos;

import java.util.UUID;

public record AddEmailContactReq(UUID contactId, String email, String notes) {
}
