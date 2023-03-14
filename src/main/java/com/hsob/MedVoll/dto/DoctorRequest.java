package com.hsob.MedVoll.dto;

import com.hsob.MedVoll.model.Speciality;

public record DoctorRequest(String name, String email, String phone, String CRM, Speciality speciality, AddressRequest address) {
}
