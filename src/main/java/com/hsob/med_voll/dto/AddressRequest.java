package com.hsob.med_voll.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRequest(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String street,

        String number,
        String complement,

        @NotBlank
        String neighborhood,

        @NotBlank
        String city,

        @NotBlank
        String state) {
}
