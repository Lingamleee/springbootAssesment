package com.example.demo.serviceImpl;

import java.util.List;

import com.example.demo.Models.Student;
import com.example.demo.repositories.StudentRepo;
import com.example.demo.services.StudentService;

public class StuServImpl implements StudentService {
	
	StudentRepo studentRepo;	

	public StuServImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		
		// TODO Auto-generated method stub
		studentRepo.save(student);
		return null;
	}

	@Override
	public List<Student> fetchStudent() {
		// TODO Auto-generated method stub
		List<Student> s = studentRepo.findAll();
		return s;
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		// TODO Auto-generated method stub
		Student s =studentRepo.findById(id).get();	
		s.setName(student.getName());
		s.setDepName(student.getDepName());
		s.setTeam(student.getTeam());
		studentRepo.save(s);
		return s;
	}

	@Override
	public Student updateName(String name, Long id) {
		// TODO Auto-generated method 
		Student s =studentRepo.findById(id).get();	
		s.setName(name);
		studentRepo.save(s);
		return s;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
		
	}

	@Override
	public void deleteAllStudents() {
		// TODO Auto-generated method stub
		studentRepo.deleteAll();		
	}

}
