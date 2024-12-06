package com.example.cadastro.controllers;

import com.example.cadastro.entitys.User;
import com.example.cadastro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class userController {

    @Autowired
    private UserService service;

    @PostMapping
    public User save(@RequestBody User user){
        User userSaved= service.save(user);
        return userSaved;

    }
}
