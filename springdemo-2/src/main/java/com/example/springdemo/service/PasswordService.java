package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.model.Password;
import com.example.springdemo.repository.PasswordRepository;
@Service
public class PasswordService 
{
	@Autowired
	PasswordRepository userRepo;
public Password saveUser(Password u)
{
	return userRepo.save(u);
}
public String validateUser(String username,String password)
{
	String result="";
	Password u=userRepo.findByUsername(username);
	if(u==null)
	{
		result="Invalid user";
	}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
	

	return result;
	}
	
	
	}


