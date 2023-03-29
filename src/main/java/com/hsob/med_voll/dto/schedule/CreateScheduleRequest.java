package com.hsob.med_voll.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateScheduleRequest(
        @NotNull
        Long schedule_id,
        @NotBlank
        String patient_id,
        @NotBlank
        String doctor_id) {


}
