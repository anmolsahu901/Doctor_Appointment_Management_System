package com.example.Doctor.Appointment.Management.System.Repository;

import com.example.Doctor.Appointment.Management.System.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public boolean existsByEmail(String email);

    public User findByEmail(String email);

}
