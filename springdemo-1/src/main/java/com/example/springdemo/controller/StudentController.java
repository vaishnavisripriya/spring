package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Student;
import com.example.springdemo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService c;
	@GetMapping(value="/api")
	public List<Student> getAll()
	{
		List<Student> d = c.getAll();
		return d;
	}
	@PostMapping(value="/saveStudent")
	public Student saveStudent(@RequestBody Student s)
	{
		return c.saveStudent(s);
		
	}
	@PutMapping(value="/updateStudent")
	public Student updateStudent(@RequestBody Student s)
	{
		return c.updateStudent(s);
	}
	@DeleteMapping(value="/delete")
    public void updateStudent(@RequestParam Integer rollno)
    {
		c.deleteStudent(rollno);
    }
	@GetMapping(value="/find/{rollno}")
	public Student findStudent(@PathVariable("rollno") Integer rollno)
	{
		return c.getStudent(rollno);
	}
	
	
	

}
