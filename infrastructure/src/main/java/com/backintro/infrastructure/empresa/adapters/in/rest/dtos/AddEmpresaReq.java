package com.backintro.infrastructure.empresa.adapters.in.rest.dtos;

public record AddEmpresaReq(String name, String nit, String email, String phone, String address) {
}
