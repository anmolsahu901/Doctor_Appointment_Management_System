package com.example.Doctor.Appointment.Management.System.Service;

import com.example.Doctor.Appointment.Management.System.Modal.Doctor;
import com.example.Doctor.Appointment.Management.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Component
public class DoctorService {

    @Autowired
    private DoctorRepository DoctorRepo;

    public List<Doctor> getAllDoctor(){
        List<Doctor> list =  (List<Doctor>) this.DoctorRepo.findAll();
        return list;
    }

    public Doctor getDoctorById(int id){
        Optional<Doctor> u =  this.DoctorRepo.findById(id);
        return u.get();

    }

    public Doctor addDoctor(Doctor doc) {
        return this.DoctorRepo.save(doc);
    }

    public void removeDoctor(int id){
        this.DoctorRepo.deleteById(id);
    }



}
