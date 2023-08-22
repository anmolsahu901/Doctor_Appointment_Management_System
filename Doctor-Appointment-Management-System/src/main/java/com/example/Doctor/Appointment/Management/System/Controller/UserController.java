package com.example.Doctor.Appointment.Management.System.Controller;

import com.example.Doctor.Appointment.Management.System.DTO.LoginResponse;
import com.example.Doctor.Appointment.Management.System.Modal.User;
import com.example.Doctor.Appointment.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }


    @GetMapping("/user/login")
    public String userLogin(){
        return "userLogin";
    }

    @GetMapping("/user/register")
    public String userRegister(){
        return "userRegister";
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = this.userService.getAllUser();
        if(list.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);


    }

//    @GetMapping("/user/login")
//    public ResponseEntity<String> login(@RequestBody LoginResponse log){
//        User existingDetails = this.userService.getUserByEmail(log.getEmail());
//        if(log.getPassword().equals(existingDetails.getPassword()))
//            return ResponseEntity.ok("login successfull");
//        else
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//
//    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User u = this.userService.getUserById(id);
        if(u==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(Optional.of(u));
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = null;
        try{
            savedUser = this.userService.addUser(user);
            return ResponseEntity.ok(savedUser);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable("userId") int userId) {
        userService.removeUser(userId);
        return ResponseEntity.ok("User with ID " + userId + " has been removed.");
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUserDetails(@PathVariable int userId, @RequestBody User updatedUser) {
        User updatedUserInfo = userService.updateUserDetails(userId, updatedUser);
        return ResponseEntity.ok(updatedUserInfo);
    }


}
