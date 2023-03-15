package com.hsob.MedVoll.dto.patient;

import com.hsob.MedVoll.model.patient.Patient;

public record PatientResponse(String name, String email, String CPF) {

    public PatientResponse(Patient patient){
        this(patient.getName(), patient.getEmail(), patient.getCPF());
    }
}
