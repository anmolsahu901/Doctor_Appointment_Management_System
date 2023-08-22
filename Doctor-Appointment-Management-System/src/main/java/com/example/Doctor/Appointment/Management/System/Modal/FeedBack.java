package com.example.Doctor.Appointment.Management.System.Modal;

import jakarta.persistence.*;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedback_id;

    private String feedbackText;

    private String AdminReply;

    @ManyToOne
    @JoinColumn(name = "id" , referencedColumnName = "user_id")
    private User user;

    public FeedBack() {
    }

    public FeedBack(int feedback_id, String feedbackText, String adminReply, User user) {
        this.feedback_id = feedback_id;
        this.feedbackText = feedbackText;
        AdminReply = adminReply;
        this.user = user;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getAdminReply() {
        return AdminReply;
    }

    public void setAdminReply(String adminReply) {
        AdminReply = adminReply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
