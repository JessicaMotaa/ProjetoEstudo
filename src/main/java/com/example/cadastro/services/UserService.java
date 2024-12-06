package com.example.cadastro.services;

import com.example.cadastro.entitys.User;
import com.example.cadastro.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
    User userSaved = repository.save(user);
        return userSaved;
    }

}
