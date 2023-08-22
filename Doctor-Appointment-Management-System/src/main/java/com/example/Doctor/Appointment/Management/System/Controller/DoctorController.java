package com.example.Doctor.Appointment.Management.System.Controller;

import com.example.Doctor.Appointment.Management.System.Modal.Doctor;
import com.example.Doctor.Appointment.Management.System.Modal.User;
import com.example.Doctor.Appointment.Management.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor/login")
    public String doctorLogin(){
        return "doctorLogin";
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> list = this.doctorService.getAllDoctor();
        if(list.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") int id) {
    Doctor doc = this.doctorService.getDoctorById(id);
        if(doc==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(Optional.of(doc));
    }

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doc){
        Doctor d = null;
        try{
            d = this.doctorService.addDoctor(doc);
            return ResponseEntity.ok(d);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<String> removeDoctor(@PathVariable("id") int id){
        this.doctorService.removeDoctor(id);
        return ResponseEntity.ok("doctor with ID " + id + " has been removed.");

    }

}
