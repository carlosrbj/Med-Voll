package com.hsob.MedVoll.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {
    private String name;
    private String email;
    private String phone;
    private String CRM;
    private Speciality speciality;
    private Address address;
}
