package com.dharam.user.services.impl;

import com.dharam.user.entities.User;
import com.dharam.user.exceptions.ResourceNotFoundException;
import com.dharam.user.repositories.UserRepository;
import com.dharam.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity<String> createUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>("user is Created successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> getUser(String id) {
        User user = userRepository.findByEmail(id);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
}
