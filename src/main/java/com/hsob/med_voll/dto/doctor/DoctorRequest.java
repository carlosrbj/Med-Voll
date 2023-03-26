package com.hsob.med_voll.dto.doctor;

import com.hsob.med_voll.dto.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRequest(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String CRM,

        @NotBlank
        String speciality,

        @NotNull
        @Valid
        AddressRequest address,

        @NotBlank
        String status) {
}
