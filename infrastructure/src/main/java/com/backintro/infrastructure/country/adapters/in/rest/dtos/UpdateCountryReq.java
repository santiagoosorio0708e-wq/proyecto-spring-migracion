package com.backintro.infrastructure.country.adapters.in.rest.dtos;

public record UpdateCountryReq(String nameCountry, String codeCountry, String description, String telephonePrefix) {
}
