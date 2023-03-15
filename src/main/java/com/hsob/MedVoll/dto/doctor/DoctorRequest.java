package com.hsob.MedVoll.dto.doctor;

import com.hsob.MedVoll.dto.AddressRequest;
import com.hsob.MedVoll.model.doctor.Speciality;
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

        @NotNull
        Speciality speciality,

        @NotNull
        @Valid
        AddressRequest address) {
}
