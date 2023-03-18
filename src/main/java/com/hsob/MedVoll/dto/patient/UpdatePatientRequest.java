package com.hsob.MedVoll.dto.patient;

import com.hsob.MedVoll.dto.AddressRequest;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientRequest(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressRequest address
) {
}
