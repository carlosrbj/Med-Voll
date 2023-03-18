package com.hsob.MedVoll.dto.patient;

import com.hsob.MedVoll.dto.AddressRequest;
import com.hsob.MedVoll.model.Status;
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
