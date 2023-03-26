package com.hsob.med_voll.dto.patient;

import com.hsob.med_voll.dto.AddressRequest;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientRequest(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressRequest address
) {
}
