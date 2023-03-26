package com.hsob.med_voll.service;

import com.hsob.med_voll.dto.patient.PatientRequest;
import com.hsob.med_voll.dto.patient.PatientResponse;
import com.hsob.med_voll.dto.patient.UpdatePatientRequest;
import com.hsob.med_voll.model.patient.Patient;
import com.hsob.med_voll.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void saveNewpatient(PatientRequest patientRequest) {
        try {
            patientRepository.save(new Patient(patientRequest));
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<PatientResponse> getAllPatient(Pageable pageable) {
        return patientRepository.findAllByStatus(pageable, "ACTIVE").map(PatientResponse::new);
    }

    public void updatePatientById(UpdatePatientRequest updatePatientRequest) {
        var patient = patientRepository.getReferenceById(updatePatientRequest.id());
        patient.updateInfo(updatePatientRequest);
    }

    public void inactivatePatient(Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.inactivate();
    }
}
