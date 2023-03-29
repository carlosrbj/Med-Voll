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

import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorResponse saveNewDoctor(DoctorRequest doctorRequest) {
        try {
            var doctor = new Doctor(doctorRequest);
            doctorRepository.save(doctor);
            return new DoctorResponse(doctor);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Page<DoctorResponse> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAllByStatus(pageable, "ACTIVE").map(DoctorResponse::new);
    }

    public DoctorResponse updateDoctorById(UpdateDoctorRequest updateDoctorRequest) {
        var doctor = doctorRepository.getReferenceById(updateDoctorRequest.id());
        doctor.updateInfo(updateDoctorRequest);
        return new DoctorResponse(doctor);
    }

    public void deleteDoctorById(Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.inactivate();
    }

    public DoctorResponse getDoctorById(Long id) {
        var doctor = doctorRepository.findById(id);
        return doctor.map(DoctorResponse::new).orElseGet(() -> new DoctorResponse(new Doctor()));
    }
}
























