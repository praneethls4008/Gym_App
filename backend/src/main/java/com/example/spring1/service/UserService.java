package com.example.spring1.service;

import com.example.spring1.model.User;
import com.example.spring1.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService{

    @Autowired
    private UserRepository userRepository;
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByMobile(long mobile) {
        return userRepository.findByMobile(mobile);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
