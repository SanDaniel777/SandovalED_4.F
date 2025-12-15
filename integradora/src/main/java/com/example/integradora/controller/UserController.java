package com.example.integradora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integradora.dto.UserRequest;
import com.example.integradora.model.User;
import com.example.integradora.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService usrService;

    public UserController(UserService userService) {
        this.usrService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserRequest request) {
        System.out.println( request.getId() + ", Nombre: " + request.getName());
        return usrService.addUser(request);
    }

    @GetMapping("/list")
    public User[] getUsers() {
        return usrService.getAllUsers();
    }
    
    @GetMapping("/{id}/search")
    public User getUser(@PathVariable int id) {
        return usrService.getUserById(id);
    }
}