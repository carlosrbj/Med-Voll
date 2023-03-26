package com.hsob.med_voll.service;

import com.hsob.med_voll.dto.doctor.DoctorRequest;
import com.hsob.med_voll.dto.doctor.DoctorResponse;
import com.hsob.med_voll.dto.doctor.UpdateDoctorRequest;
import com.hsob.med_voll.model.doctor.Doctor;
import com.hsob.med_voll.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return doctorRepository.findAllByStatus(pageable, "ACTIVE").map(DoctorResponse::new);
    }

    public void updateDoctorById(UpdateDoctorRequest updateDoctorRequest) {
        var doctor = doctorRepository.getReferenceById(updateDoctorRequest.id());
        doctor.updateInfo(updateDoctorRequest);
    }

    public void deleteDoctorById(Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.inactivate();
    }
}
























