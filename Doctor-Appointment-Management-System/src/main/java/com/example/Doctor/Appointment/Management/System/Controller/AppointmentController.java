package com.example.Doctor.Appointment.Management.System.Controller;

import com.example.Doctor.Appointment.Management.System.Modal.Appointment;
import com.example.Doctor.Appointment.Management.System.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/appointment")
    public ResponseEntity<List<Appointment>>  getAllAppointments(){
        List<Appointment> list = this.service.getAllAppointment();
        if(list.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id")  int id){
        Appointment a = this.service.getAppointmentById(id);
        if(a==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(Optional.of(a));
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        Appointment a = null;
        try{
            a = this.service.bookAppointment(appointment);
            return ResponseEntity.ok(a);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/appointment/{appointmentId}")
    public ResponseEntity<String> removeUser(@PathVariable("appointmentId") int id) {
        this.service.removeAppointment(id);
        return ResponseEntity.ok("Appointment with ID " + id + " has been removed.");
    }

    @PutMapping("/appointment/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("appointmentId") int id,@RequestBody Appointment appointment){
        Appointment ap = this.service.updateAppointment(id,appointment);
        return ResponseEntity.ok(ap);
    }





}
