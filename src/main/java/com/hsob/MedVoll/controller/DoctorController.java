package com.hsob.MedVoll.controller;

import com.hsob.MedVoll.dto.doctor.DoctorRequest;
import com.hsob.MedVoll.dto.doctor.DoctorResponse;
import com.hsob.MedVoll.dto.doctor.UpdateDoctorRequest;
import com.hsob.MedVoll.service.DoctorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorsService doctorsService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> saveNewDoctor(@RequestBody @Valid DoctorRequest doctorRequest){
        doctorsService.saveNewDoctor(doctorRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("listAll")
    public ResponseEntity<Page<DoctorResponse>> getAllDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return ResponseEntity.of(Optional.ofNullable(doctorsService.getAllDoctors(pageable)));
    }


    @PutMapping("/update")
    @Transactional
    public ResponseEntity<?> updateDoctorbyid(@RequestBody @Valid UpdateDoctorRequest updateDoctorRequest){
        doctorsService.updateDoctorById(updateDoctorRequest);
        return ResponseEntity.ok().build();
    }








}
