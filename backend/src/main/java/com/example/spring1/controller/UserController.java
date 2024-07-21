package com.example.spring1.controller;

import com.example.spring1.model.User;
import com.example.spring1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping("/new")
public ResponseEntity<?> CreateUser(@RequestBody User user){
    System.out.println("in post");
        try{
            userService.createNewUser(user);
            return new ResponseEntity<>("User Registered successfully.", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/d")
    public ResponseEntity<?> getAllUsersd(){
        return new ResponseEntity<>("dd", HttpStatus.OK);
    }
}