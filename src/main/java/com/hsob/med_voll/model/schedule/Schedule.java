package com.hsob.med_voll.model.schedule;


import com.hsob.med_voll.model.doctor.Doctor;
import com.hsob.med_voll.model.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "schedules")
@Entity(name = "Schedule")
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime scheduleDate;
    private String status;

    public Schedule(LocalDateTime scheduleDate, String status) {
        this.scheduleDate = scheduleDate;
        this.status = status;
        this.doctor = null;
        this.patient = null;
    }
}
