package com.hsob.MedVoll.controller;

import com.hsob.MedVoll.dto.schedule.AvailableScheduleResponse;
import com.hsob.MedVoll.model.schedule.Schedule;
import com.hsob.MedVoll.repository.ScheduleRepository;
import com.hsob.MedVoll.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @PostMapping("/create_schedules")
    @Transactional
    public ResponseEntity<Schedule> populateAvailableSchedules(@RequestHeader Integer quantity){
        scheduleService.populateAvailableSchedules(quantity);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/get-availables")
    public ResponseEntity<Page<AvailableScheduleResponse>> getAvailableSchedules(@PageableDefault(size = 10, sort = {"schedule_date"}) Pageable pageable){
        return ResponseEntity.of(Optional.ofNullable(scheduleService.getAvailableSchedules(pageable)));
    }
}
