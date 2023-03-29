package com.hsob.med_voll.controller;

import com.hsob.med_voll.dto.doctor.DoctorResponse;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<PatientResponse> saveNewPatient(@RequestBody @Valid PatientRequest patientRequest, UriComponentsBuilder uriBuilder){
        var patientResponse = patientService.saveNewpatient(patientRequest);
        var uri = uriBuilder.path("/patients/register/{id}").buildAndExpand(patientResponse).toUri();
        return ResponseEntity.created(uri).body(patientResponse);
    }

    @GetMapping("/listAll")
    public ResponseEntity<Page<PatientResponse>> getAllPatient(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return ResponseEntity.ok(patientService.getAllPatient(pageable));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<PatientResponse> updatePatientById(@RequestBody @Valid UpdatePatientRequest updatePatientRequest){
        return ResponseEntity.ok(patientService.updatePatientById(updatePatientRequest));
    }

    @DeleteMapping("/inactivate/{id}")
    @Transactional
    public ResponseEntity<?> inactivatePatient(@PathVariable Long id){
        patientService.inactivatePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-patient-by-id/{id}")
    public ResponseEntity<PatientResponse> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getDoctorById(id));
    }
}
