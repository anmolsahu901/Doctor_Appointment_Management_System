package com.example.Doctor.Appointment.Management.System.Service;

import com.example.Doctor.Appointment.Management.System.Modal.User;
import com.example.Doctor.Appointment.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        List<User> list =  (List<User>) this.userRepository.findAll();
        return list;
    }

    public User getUserById(int id){
        Optional<User> u =  this.userRepository.findById(id);
        return u.get();

    }

    public User getUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(int userId) {
        userRepository.deleteById(userId);
    }

    public User updateUserDetails(int userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }
}

