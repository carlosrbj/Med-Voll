package com.hsob.MedVoll.controller;

import com.hsob.MedVoll.model.schedule.Schedule;
import com.hsob.MedVoll.repository.ScheduleRepository;
import com.hsob.MedVoll.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @PostMapping("create_schedules")
    @Transactional
    public ResponseEntity<Schedule> populateAvailableSchedules(){
        scheduleService.populateAvailableSchedules();
        return ResponseEntity.ok().build();
    }


}
