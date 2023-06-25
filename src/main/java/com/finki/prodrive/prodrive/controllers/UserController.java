package com.finki.prodrive.prodrive.controllers;

import com.finki.prodrive.prodrive.model.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {

    /*
     * Samo metodov dodaj go na postoeckata klasa
     * */

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
