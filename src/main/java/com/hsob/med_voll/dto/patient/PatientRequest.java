package com.hsob.med_voll.dto.patient;

import com.hsob.med_voll.dto.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientRequest(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String phone,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String CPF,

        @NotNull
        @Valid
        AddressRequest address,

        @NotBlank
        String status) {


}
