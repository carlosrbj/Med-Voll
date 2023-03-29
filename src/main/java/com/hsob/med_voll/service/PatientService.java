package com.hsob.med_voll.service;

import com.hsob.med_voll.dto.patient.PatientRequest;
import com.hsob.med_voll.dto.patient.PatientResponse;
import com.hsob.med_voll.dto.patient.UpdatePatientRequest;
import com.hsob.med_voll.model.patient.Patient;
import com.hsob.med_voll.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientResponse saveNewpatient(PatientRequest patientRequest) {
        try {
            var patient = new Patient(patientRequest);
            patientRepository.save(patient);
            return new PatientResponse(patient);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<PatientResponse> getAllPatient(Pageable pageable) {
        return patientRepository.findAllByStatus(pageable, "ACTIVE").map(PatientResponse::new);
    }

    public PatientResponse updatePatientById(UpdatePatientRequest updatePatientRequest) {
        var patient = patientRepository.getReferenceById(updatePatientRequest.id());
        patient.updateInfo(updatePatientRequest);
        return new PatientResponse(patient);
    }

    public void inactivatePatient(Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.inactivate();
    }

    public PatientResponse getDoctorById(Long id) {
        var patient = patientRepository.findById(id);
       return patient.map(PatientResponse::new).orElseGet(() -> new PatientResponse(new Patient()));
    }
}
