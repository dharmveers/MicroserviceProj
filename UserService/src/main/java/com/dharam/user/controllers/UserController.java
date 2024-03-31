package com.dharam.user.controllers;

import com.dharam.user.entities.User;
import com.dharam.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String userid = UUID.randomUUID().toString();
        user.setUserID(userid);
        return userService.createUser(user);
    }
    @GetMapping("/getUser/{userid}")
    public ResponseEntity<User> getUser(@PathVariable String userid){
        return userService.getUser(userid);
    }
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return userService.getAllUser();
    }
}
