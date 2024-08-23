package com.example.spring1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/access")
public class AccessController {

    @GetMapping("/user")
    public String userHome(@RequestParam Optional<String> name){
       return name.isPresent() ? "User Home: "+name.get() : "User Home: default";
    }

    @GetMapping("/admin")
    public String AdminHome(@RequestParam Optional<String> name){
        return name.isPresent() ? "Admin Home: "+name.get() : "Admin Home: default";
    }

    @GetMapping("/")
    public String Home(@RequestParam Optional<String> name){
        return name.isPresent() ? "Home: "+name.get() : "Home: default";
    }
}
