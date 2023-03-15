package com.hsob.MedVoll.service;

import com.hsob.MedVoll.dto.doctor.DoctorRequest;
import com.hsob.MedVoll.dto.doctor.DoctorResponse;
import com.hsob.MedVoll.dto.doctor.UpdateDoctorRequest;
import com.hsob.MedVoll.model.doctor.Doctor;
import com.hsob.MedVoll.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void saveNewDoctor(DoctorRequest doctorRequest) {
        try {
            doctorRepository.save(new Doctor(doctorRequest));
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<DoctorResponse> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable).map(DoctorResponse::new);
    }

    public void updateDoctorById(UpdateDoctorRequest updateDoctorRequest) {
        var doctor = doctorRepository.getReferenceById(updateDoctorRequest.id());
        doctor.updateInfo(updateDoctorRequest);
    }
}
























