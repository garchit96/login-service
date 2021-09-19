package com.example.loginservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loginservice.entities.Role;
import com.example.loginservice.entities.User;
import com.example.loginservice.repository.RoleRepository;
import com.example.loginservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role helpdeskRole = new Role();
        helpdeskRole.setRoleName("Helpdesk");
        helpdeskRole.setRoleDescription("Helpdesk role");
        roleRepository.save(helpdeskRole);

        User adminUser = new User();
        adminUser.setUserName("admin@gmail");
        adminUser.setUserPassword(getEncodedPassword("admin123"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
        user.setUserName("raj@gmail");
        user.setUserPassword(getEncodedPassword("raj123"));
        Set<Role> helpdeskRoles = new HashSet<>();
        helpdeskRoles.add(helpdeskRole);
        user.setRole(helpdeskRoles);
        userRepository.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleRepository.findById("Helpdesk").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserName(user.getUserName());
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
