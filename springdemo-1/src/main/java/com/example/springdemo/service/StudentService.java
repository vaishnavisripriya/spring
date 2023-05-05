package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.model.Student;
import com.example.springdemo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository a ;
	public List<Student>getAll()
	{
		List<Student> b = a.findAll();
		return b;
	}
	public Student saveStudent(Student s)
	{
		Student obj = a.save(s);
		return obj;
	}
	public Student updateStudent(Student s)
	{
		Student obj = a.save(s);
		return obj;
	}
	public void deleteStudent(int rollno)
	{
		a.deleteById(rollno);
	}
	public Student getStudent(int rollno)
	{
		return  a.findById(rollno).get();
	}

}
