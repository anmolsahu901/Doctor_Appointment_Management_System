package com.example.Doctor.Appointment.Management.System.Controller;

import com.example.Doctor.Appointment.Management.System.Modal.Admin;
import com.example.Doctor.Appointment.Management.System.Service.AdminService;
import com.example.Doctor.Appointment.Management.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/admin/addDoctor")
    public String addDoctor(){
        return "AddDoctor";
    }

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "AdminLogin";
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        Admin a = null;
        try{
            a = this.adminService.addAdmin(admin);
            return ResponseEntity.ok(a);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
