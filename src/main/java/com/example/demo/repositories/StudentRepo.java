package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Models.Student;

public interface StudentRepo extends MongoRepository<Student, Long>{
	List findByTeam(String team);
    List findByName(String name);
}
