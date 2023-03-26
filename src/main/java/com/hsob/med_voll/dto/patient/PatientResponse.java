package com.hsob.med_voll.dto.patient;

import com.hsob.med_voll.model.patient.Patient;

public record PatientResponse(Long id, String name, String email, String CPF, String status) {

    public PatientResponse(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCPF(), patient.getStatus());
    }
}
