package com.Darden.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Darden.models.Student;

public interface StudentRepo extends MongoRepository<Student, Integer> {
	 
}
