package com.example.Doctor.Appointment.Management.System.Service;

import com.example.Doctor.Appointment.Management.System.Modal.Appointment;
import com.example.Doctor.Appointment.Management.System.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    public List<Appointment> getAllAppointment(){
        List<Appointment> list = this.appointmentRepo.findAll();
        return list;
    }

    public Appointment bookAppointment(Appointment ap){
        return this.appointmentRepo.save(ap);
    }

    public Appointment getAppointmentById(int id)
    {
        Optional<Appointment> ap =  this.appointmentRepo.findById(id);
        return ap.get();
    }

    public void removeAppointment(int id){
        this.appointmentRepo.deleteById(id);
    }

    public Appointment updateAppointment(int id,Appointment ap){
        Optional<Appointment> existingOp = this.appointmentRepo.findById(id);
        if(existingOp.isPresent()){
            Appointment appointment = existingOp.get();
            appointment.setDate(ap.getDate());
            appointment.setLocation(ap.getLocation());
            appointment.setStatus(ap.getStatus());
            appointment.setTimeSlot(ap.getTimeSlot());
            appointment.setTotalCost(ap.getTotalCost());
            return this.appointmentRepo.save(appointment);
        }
        else{
            return null;
        }
    }

}
