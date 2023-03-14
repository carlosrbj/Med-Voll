package com.hsob.MedVoll.controller;

import com.hsob.MedVoll.dto.DoctorRequest;
import com.hsob.MedVoll.model.Doctor;
import com.hsob.MedVoll.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/register")
    @Transactional
    public void saveNewDoctor(@RequestBody DoctorRequest doctorRequest){
        doctorRepository.save(new Doctor(doctorRequest));
    }
}
