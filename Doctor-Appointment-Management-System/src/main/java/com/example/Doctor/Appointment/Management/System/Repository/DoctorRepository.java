package com.example.Doctor.Appointment.Management.System.Repository;

import com.example.Doctor.Appointment.Management.System.Modal.Doctor;
import com.example.Doctor.Appointment.Management.System.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public boolean existsByEmail(String email);

    public Doctor findByEmail(String email);
}
