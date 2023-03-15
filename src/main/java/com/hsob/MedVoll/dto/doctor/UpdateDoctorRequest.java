package com.hsob.MedVoll.dto.doctor;

import com.hsob.MedVoll.dto.AddressRequest;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorRequest(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressRequest address) {


}
