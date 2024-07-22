package com.example.spring1.service;

import com.example.spring1.model.User;
import com.example.spring1.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

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

    public void createNewUser(User user) throws Exception {
    System.out.println(user);
        System.out.println(user.mobile());
        if (userRepository.findByMobile(user.mobile()).isPresent()) {
            throw new Exception("Mobile number is already registered!");
        }
        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw new Exception("Email is already registered!");
        }
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
