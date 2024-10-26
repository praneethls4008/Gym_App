package com.example.spring1.service;

import com.example.spring1.model.User;
import com.example.spring1.respository.UserRepository;
import com.example.spring1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

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

    public String getUsername(String id){
        return userRepository.findById(id).orElseThrow().getUsername();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void createNewUser(User user) throws Exception {
        if (userRepository.findByMobile(user.getMobile()).isPresent()) {
            throw new Exception("Mobile number is already registered!");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email is already registered!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String id) throws Exception {
        userRepository.deleteById(id);
        if(userRepository.findById(id).isPresent()){
            throw new Exception("User Account deletion failed. Try again!");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
