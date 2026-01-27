package com.okulab.okulab.controller;


import com.okulab.okulab.models.User;
import com.okulab.okulab.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {
    private final UserRepository userRepository;
    public AuthController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("Received user: " + user.getUsername());
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        user.setRole("ROLE_USER");
        user.setHasPaidAccess(false);

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser.isPresent()){
            if(foundUser.get().getPassword().equals(user.getPassword())){
                return ResponseEntity.ok("Login Successful!");
            }else{
                return ResponseEntity.badRequest().body("Error: Invalid password");
            }
        } else{
            return ResponseEntity.badRequest().body("Error: User not found!");
        }

    }
}
