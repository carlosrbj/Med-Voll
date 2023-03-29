package com.hsob.med_voll.controller;

import com.hsob.med_voll.dto.doctor.DoctorRequest;
import com.hsob.med_voll.dto.doctor.DoctorResponse;
import com.hsob.med_voll.dto.doctor.UpdateDoctorRequest;
import com.hsob.med_voll.service.DoctorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorsService doctorsService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<DoctorResponse> saveNewDoctor(@RequestBody @Valid DoctorRequest doctorRequest, UriComponentsBuilder uriBuilder){
        var doctorResponse = doctorsService.saveNewDoctor(doctorRequest);
        var uri = uriBuilder.path("/doctors/register/{id}").buildAndExpand(doctorResponse).toUri();
        return ResponseEntity.created(uri).body(doctorResponse);
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<DoctorResponse>> getAllDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return ResponseEntity.of(Optional.ofNullable(doctorsService.getAllDoctors(pageable)));
    }


    @PutMapping("/update")
    @Transactional
    public ResponseEntity<DoctorResponse> updateDoctorbyid(@RequestBody @Valid UpdateDoctorRequest updateDoctorRequest){
        return ResponseEntity.ok(doctorsService.updateDoctorById(updateDoctorRequest));
    }


    @DeleteMapping("/inactivate/{id}")
    @Transactional
    public ResponseEntity<?> deleteDoctorById(@PathVariable Long id){
        doctorsService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get-doctor-by-id/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorsService.getDoctorById(id));
    }

}
