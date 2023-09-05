package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Student;

@Service
public interface StudentService {
	
	Student saveStudent(Student student);
	
	List<Student> fetchStudent();
	
	Student updateStudent(Student student, Long id);
	
	Student updateName(String name, Long id);
	
	void deleteStudent(Long id);
	
	void deleteAllStudents();	

}
