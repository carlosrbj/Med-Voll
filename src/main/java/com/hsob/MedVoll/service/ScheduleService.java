package com.hsob.MedVoll.service;

import com.hsob.MedVoll.model.schedule.Schedule;
import com.hsob.MedVoll.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    private static final LocalDateTime HORARIO_INICIAL = LocalDateTime.of(LocalDate.now(), LocalTime.of(7,0));
    private static final LocalDateTime HORARIO_FINAL = LocalDateTime.of(LocalDate.of(2023, 4, 17), LocalTime.of(19,0));
    private static final int INTERVALO = 60; // minutos
    private static final DayOfWeek[] DIAS_UTEIS = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};

        public static List<LocalDateTime> createBookings() {
        List<LocalDateTime> bookings = new ArrayList<>();
        LocalDateTime booking = HORARIO_INICIAL;
        while (booking.isBefore(HORARIO_FINAL)) {
            if (isDiaUtil(booking.getDayOfWeek())) bookings.add(booking);
            booking = booking.plusMinutes(INTERVALO);
        }
        return bookings;
    }

    private static boolean isDiaUtil(DayOfWeek dia) {
        for (DayOfWeek diaUtil : DIAS_UTEIS) {
            if (dia == diaUtil) return true;
        }
        return false;
    }

    public void populateAvailableSchedules(){
        List<LocalDateTime> dates = createBookings();
        List<Schedule> schedules = new ArrayList<>();
        dates.forEach(h -> schedules.add(new Schedule(h, "AVAILABLE")));
        schedules.forEach(s -> scheduleRepository.save(s));
    }

}
