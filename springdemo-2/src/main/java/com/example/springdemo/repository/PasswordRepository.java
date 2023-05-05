package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Password;
@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer>
{
	Password findByUsername(String username);

}
