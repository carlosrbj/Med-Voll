package com.hsob.MedVoll.dto.schedule;

import com.hsob.MedVoll.model.schedule.Schedule;

import java.time.LocalDateTime;

public record AvailableScheduleResponse(Long id, LocalDateTime scheduleDate, String status) {

    public AvailableScheduleResponse(Schedule schedule){
        this(schedule.getId(), schedule.getSchedule_date(), schedule.getStatus());
    }
}
