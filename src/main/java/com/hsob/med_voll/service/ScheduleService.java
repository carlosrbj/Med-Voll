package com.hsob.med_voll.service;

import com.hsob.med_voll.dto.schedule.AvailableScheduleResponse;
import com.hsob.med_voll.dto.schedule.CreateScheduleRequest;
import com.hsob.med_voll.model.schedule.Schedule;
import com.hsob.med_voll.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    private static final LocalDateTime START_TIME = LocalDateTime.of(LocalDate.now(), LocalTime.of(7,0));
    private static final LocalDateTime FINAL_TIME = LocalDateTime.of(LocalDate.of(2025, 1, 1), LocalTime.of(19,0));
    private static final int INTERVAL = 60; // minutos
    private static final DayOfWeek[] DAYS_OF_THE_WEEK = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};

    public static List<LocalDateTime> createBookings(Integer quantity) {
        List<LocalDateTime> bookings = new ArrayList<>();
        LocalDateTime booking = START_TIME;
        while (booking.isBefore(FINAL_TIME)) {
            if (isDiaUtil(booking.getDayOfWeek()) && bookings.size() < quantity) bookings.add(booking);
            booking = booking.plusMinutes(INTERVAL);
        }
        return bookings;
    }

    public static boolean isDiaUtil(DayOfWeek dia) {
        for (DayOfWeek dayOfWeek : DAYS_OF_THE_WEEK) {
            if (dia == dayOfWeek) return true;
        }
        return false;
    }

    public List<AvailableScheduleResponse> populateAvailableSchedules(Integer quantity){
        List<LocalDateTime> dates = createBookings(quantity);
        List<Schedule> schedules = new ArrayList<>();
        List<AvailableScheduleResponse> response = new ArrayList<>();
        dates.forEach(h -> schedules.add(new Schedule(h, "AVAILABLE")));
        schedules.forEach(s -> {
            response.add(new AvailableScheduleResponse(s));
            scheduleRepository.save(s);
        });

        return response;
    }

    public Page<AvailableScheduleResponse> getAvailableSchedules(Pageable pageable) {
        return scheduleRepository.findAllByStatus(pageable,"AVAILABLE").map(AvailableScheduleResponse::new);
    }

    public Schedule scheduleAppointment(CreateScheduleRequest createScheduleRequest) {
        Optional<Schedule> schedule = scheduleRepository.findById(createScheduleRequest.schedule_id());
        if (schedule.isPresent()){

        }

        return new Schedule();
    }
}
