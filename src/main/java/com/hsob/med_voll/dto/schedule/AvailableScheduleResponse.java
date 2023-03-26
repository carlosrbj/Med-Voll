package com.hsob.med_voll.dto.schedule;

import com.hsob.med_voll.model.schedule.Schedule;

import java.time.LocalDateTime;

public record AvailableScheduleResponse(Long id, LocalDateTime scheduleDate, String status) {

    public AvailableScheduleResponse(Schedule schedule){
        this(schedule.getId(), schedule.getScheduleDate(), schedule.getStatus());
    }
}
