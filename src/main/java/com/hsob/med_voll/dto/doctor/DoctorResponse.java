package com.hsob.med_voll.dto.doctor;

import com.hsob.med_voll.model.doctor.Doctor;

public record DoctorResponse(Long id, String name, String email, String CRM, String speciality, String status) {

    public DoctorResponse(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCRM(), doctor.getSpeciality(), doctor.getStatus());
    }


}
