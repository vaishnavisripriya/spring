package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pets;
import com.example.demo.repository.PetsRepository;
@RestController
@RequestMapping("/api/pets")
public class PetsController {
	@Autowired
	private PetsRepository petsRepo;
	@GetMapping
	public List<Pets>getPets(){
		return this.petsRepo.findAll();
	
	}
	@PostMapping
	public Pets addPets(@RequestBody Pets d) {
		return this.petsRepo.save(d);
	}

}
