package com.example.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Password;
import com.example.springdemo.service.PasswordService;
@RestController
public class PasswordController 
{
	@Autowired
	PasswordService usrService;
	@PostMapping("/checkLogin")
		public String validateUser(@RequestBody Password u)
		{
		System.out.println(u.getUsername());
			return usrService.validateUser(u.getUsername(),u.getPassword());
		}
	//for putting new data
	@PostMapping("/addUser")
	public Password AddPassword(@RequestBody Password u)
	{
	return usrService.saveUser(u);
	}

}
