package com.example.spring1.controller;

import com.example.spring1.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/get")
    public void getUser(){

    }
}