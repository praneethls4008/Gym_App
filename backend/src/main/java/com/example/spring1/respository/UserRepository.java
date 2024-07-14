package com.example.spring1.respository;

import com.example.spring1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findById(String id);
    Optional<User> findByMobile(long mobile);
    Optional<User> findByEmail(String email);
}
