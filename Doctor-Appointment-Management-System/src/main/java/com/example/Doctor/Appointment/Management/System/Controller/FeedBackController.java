package com.example.Doctor.Appointment.Management.System.Controller;

import com.example.Doctor.Appointment.Management.System.Modal.FeedBack;
import com.example.Doctor.Appointment.Management.System.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack){
        FeedBack f = null;
        try{
            f = this.feedbackService.addFeedback(feedBack);
            return ResponseEntity.ok(f);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<FeedBack> replyFeedBack(@PathVariable int id, @RequestBody FeedBack feedBack){
        FeedBack f = this.feedbackService.updateFeedback(id,feedBack);
        return  ResponseEntity.ok(f);
    }



}
