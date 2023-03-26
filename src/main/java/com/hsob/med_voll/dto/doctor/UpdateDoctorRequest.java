package com.hsob.med_voll.dto.doctor;

import com.hsob.med_voll.dto.AddressRequest;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorRequest(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressRequest address) {


}
