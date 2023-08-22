package com.example.Doctor.Appointment.Management.System.Service;

import com.example.Doctor.Appointment.Management.System.Modal.Admin;
import com.example.Doctor.Appointment.Management.System.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin addAdmin(Admin admin){
        Admin a = this.adminRepo.save(admin);
        return a;
    }

}
