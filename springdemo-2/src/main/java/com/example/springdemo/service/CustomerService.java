package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.model.Customer;
import com.example.springdemo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	
	public List<Customer> fetchAllCustomers(){
		List<Customer> c=custRepo.findAll();
		return c;
	}
	
	public Customer saveCustomers(Customer p) {
		Customer s=custRepo.save(p);
		return s;
	}

}
