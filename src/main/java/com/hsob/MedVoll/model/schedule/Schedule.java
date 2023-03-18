package com.hsob.MedVoll.model.schedule;


import com.hsob.MedVoll.model.doctor.Doctor;
import com.hsob.MedVoll.model.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedules")
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Nullable
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @Nullable
    private Doctor doctor;
    private LocalDateTime scheduleDate;
    private String status;

    public Schedule(LocalDateTime scheduleDate, String status) {
        this.scheduleDate = scheduleDate;
        this.status = status;
    }
}
