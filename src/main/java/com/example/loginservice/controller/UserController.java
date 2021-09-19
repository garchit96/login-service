package com.example.loginservice.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginservice.entities.User;
import com.example.loginservice.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forHelpdesk"})
    @PreAuthorize("hasRole('Helpdesk')")
    public String forUser(){
        return "This URL is only accessible to the helpdesk";
    }
    
//    @GetMapping({"/forHelpdesk"})
//    @PreAuthorize("hasAnyRole('Helpdesk', 'Admin')")
//    public String forUser(){
//        return "This URL is only accessible to the helpdesk";
//    }
}