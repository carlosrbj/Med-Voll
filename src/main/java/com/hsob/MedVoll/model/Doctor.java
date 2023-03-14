package com.hsob.MedVoll.model;

import com.hsob.MedVoll.dto.DoctorRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
@Entity(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String CRM;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Embedded
//    com o @Embedded o Address fica em uma classe separada, mas na tabela ele considera
//    como atributos de Doctor
    private Address address;

    public Doctor(DoctorRequest doctorRequest) {
        this.name = doctorRequest.name();
        this.email = doctorRequest.email();
        this.phone = doctorRequest.phone();
        this.CRM = doctorRequest.CRM();
        this.speciality = doctorRequest.speciality();
        this.address = new Address(doctorRequest.address());
    }
}
