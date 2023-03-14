package com.hsob.MedVoll.controller;

import com.hsob.MedVoll.dto.DoctorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping("/register")
    public void saveNewDoctor(@RequestBody DoctorRequest doctorRequest){
        System.out.println(doctorRequest);
    }
}
