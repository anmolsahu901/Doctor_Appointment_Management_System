package com.example.Doctor.Appointment.Management.System.Service;

import com.example.Doctor.Appointment.Management.System.Modal.FeedBack;
import com.example.Doctor.Appointment.Management.System.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepo;

    public FeedBack addFeedback(FeedBack feedBack){
        return  this.feedbackRepo.save(feedBack);
    }

    public FeedBack updateFeedback(int id,FeedBack feedBack){
        Optional<FeedBack> op = this.feedbackRepo.findById(id);
        if(op.isPresent()){
            FeedBack f = op.get();
            f.setFeedbackText(feedBack.getFeedbackText());
            f.setAdminReply(feedBack.getAdminReply());
            return this.feedbackRepo.save(f);
        }
        return null;
    }


}
