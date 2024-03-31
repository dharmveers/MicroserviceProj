package com.dharam.user.services;

import com.dharam.user.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<String> createUser(User user);

    ResponseEntity<User> getUser(String id);

    ResponseEntity<List<User>> getAllUser();
}
