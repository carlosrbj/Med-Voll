package com.hsob.med_voll.controller;

import com.hsob.med_voll.dto.patient.PatientRequest;
import com.hsob.med_voll.dto.patient.PatientResponse;
import com.hsob.med_voll.dto.patient.UpdatePatientRequest;
import com.hsob.med_voll.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> saveNewPatient(@RequestBody @Valid PatientRequest patientRequest){
        patientService.saveNewpatient(patientRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<PatientResponse>> getAllPatient(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return ResponseEntity.ok(patientService.getAllPatient(pageable));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<?> updatePatientById(@RequestBody @Valid UpdatePatientRequest updatePatientRequest){
        patientService.updatePatientById(updatePatientRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/inactivate/{id}")
    @Transactional
    public ResponseEntity<?> inactivatePatient(@PathVariable Long id){
        patientService.inactivatePatient(id);
        return ResponseEntity.ok().build();
    }
}
