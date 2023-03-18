package com.hsob.MedVoll.model.patient;

import com.hsob.MedVoll.dto.patient.PatientRequest;
import com.hsob.MedVoll.dto.patient.UpdatePatientRequest;
import com.hsob.MedVoll.model.Address;
import com.hsob.MedVoll.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.hsob.MedVoll.model.Status.ACTIVE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
@Entity(name = "Patient")
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
    private String status;

    public Patient(PatientRequest patientRequest) {
        this.name = patientRequest.name();
        this.email = patientRequest.email();
        this.phone = patientRequest.phone();
        this.CPF = patientRequest.CPF();
        this.address = new Address(patientRequest.address());
        this.status = patientRequest.status();
    }

    public void updateInfo(UpdatePatientRequest updatePatientRequest) {
        if (updatePatientRequest.name() != null) this.name = updatePatientRequest.name();
        if (updatePatientRequest.phone() != null) this.phone = updatePatientRequest.phone();
        if (updatePatientRequest.address() != null) this.address.updateInfo(updatePatientRequest.address());
    }

    public void inactivate() {
        this.status = "INACTIVE";
    }
}
