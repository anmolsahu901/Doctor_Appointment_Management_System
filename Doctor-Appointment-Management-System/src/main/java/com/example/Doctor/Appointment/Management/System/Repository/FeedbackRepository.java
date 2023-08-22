package com.example.Doctor.Appointment.Management.System.Repository;

import com.example.Doctor.Appointment.Management.System.Modal.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedBack,Integer> {
}
