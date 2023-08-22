package com.example.Doctor.Appointment.Management.System.Repository;

import com.example.Doctor.Appointment.Management.System.Modal.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
