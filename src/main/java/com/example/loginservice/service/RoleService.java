package com.example.loginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginservice.entities.Role;
import com.example.loginservice.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
