package com.hsob.med_voll.model.doctor;

import com.hsob.med_voll.dto.doctor.DoctorRequest;
import com.hsob.med_voll.dto.doctor.UpdateDoctorRequest;
import com.hsob.med_voll.model.Address;
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
    private String speciality;
    @Embedded
//    com o @Embedded o Address fica em uma classe separada, mas na tabela ele considera
//    como atributos de Doctor
    private Address address;
    private String status;

    public Doctor(DoctorRequest doctorRequest) {
        this.name = doctorRequest.name();
        this.email = doctorRequest.email();
        this.phone = doctorRequest.phone();
        this.CRM = doctorRequest.CRM();
        this.speciality = doctorRequest.speciality();
        this.address = new Address(doctorRequest.address());
        this.status = doctorRequest.status();
    }

    public void updateInfo(UpdateDoctorRequest updateDoctorRequest) {
        if (updateDoctorRequest.name() != null) this.name = updateDoctorRequest.name();
        if (updateDoctorRequest.phone() != null) this.phone = updateDoctorRequest.phone();
        if (updateDoctorRequest.address() != null) this.address.updateInfo(updateDoctorRequest.address());
    }

    public void inactivate() {
        this.status = "INACTIVE";
    }
}
























