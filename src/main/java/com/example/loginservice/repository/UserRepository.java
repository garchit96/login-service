package com.example.loginservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

	

}
