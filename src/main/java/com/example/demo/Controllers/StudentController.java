package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentRepo studentRepo;
	
	StudentService studentService;
	
	public StudentController() {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		
//		List<Student> s = studentService.fetchStudent();
//		System.out.println(s);
//		return s;
		return studentRepo.findAll();		
	}
	
	@PostMapping("/add")
	public void addStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		studentRepo.save(student);
	}
	
	@PutMapping("/upName/{id}")
	public void updateName(@RequestBody String name, @PathVariable("id") Long id) {
		Student s =studentRepo.findById(id).get();	
		s.setName(name);
		studentRepo.save(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		studentRepo.deleteById(id);		
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAll() {
		studentRepo.deleteAll();
	}
	
	

}
