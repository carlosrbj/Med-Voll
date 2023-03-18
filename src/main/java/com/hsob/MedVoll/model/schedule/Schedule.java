package com.hsob.MedVoll.model.schedule;


import com.hsob.MedVoll.dto.schedule.AvailableScheduleResponse;
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
@Entity(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Nullable
    private Patient patient_id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @Nullable
    private Doctor doctor_id;
    @Column(name = "schedule_date")
    private LocalDateTime schedule_date;
    private String status;

    public Schedule(LocalDateTime scheduleDate, String status) {
        this.schedule_date = scheduleDate;
        this.status = status;
    }

    public Schedule(AvailableScheduleResponse scheduleResponse) {
        this.schedule_date = scheduleResponse.scheduleDate();
        this.status = scheduleResponse.status();
    }
}
