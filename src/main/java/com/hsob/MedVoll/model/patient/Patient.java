package com.hsob.MedVoll.model.patient;

import com.hsob.MedVoll.dto.patient.PatientRequest;
import com.hsob.MedVoll.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String CPF;
    @Embedded
    private Address address;

    public Patient(PatientRequest patientRequest) {
        this.name = patientRequest.name();
        this.email = patientRequest.email();
        this.phone = patientRequest.phone();
        this.CPF = patientRequest.CPF();
        this.address = new Address(patientRequest.address());
    }
}
