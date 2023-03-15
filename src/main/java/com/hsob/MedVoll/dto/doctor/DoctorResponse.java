package com.hsob.MedVoll.dto.doctor;

import com.hsob.MedVoll.model.doctor.Doctor;
import com.hsob.MedVoll.model.doctor.Speciality;

public record DoctorResponse(Long id, String name, String email, String CRM, Speciality speciality) {

    public DoctorResponse(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCRM(), doctor.getSpeciality());
    }


}
