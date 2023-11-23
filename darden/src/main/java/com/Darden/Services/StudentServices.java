package com.Darden.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Darden.models.Student;
import com.Darden.repo.StudentRepo;

@Service
public class StudentServices {

    private static final Logger logger = LoggerFactory.getLogger(StudentServices.class);

    @Autowired
    private StudentRepo repo;

    public Student addStudent(Student student) {
        repo.save(student);
        logger.info("Added a new student: {}", student);
        return student;
    }

    public List<Student> getStud() {
        List<Student> students = repo.findAll();
        logger.info("Retrieved all students: {}", students);
        return students;
    }

    public void del_Stud(int id) {
        repo.deleteById(id);
        logger.info("Deleted student with ID: {}", id);
    }

    public Student updt_Stud(Student student, int id) {
        repo.deleteById(id);
        repo.save(student);
        logger.info("Updated student with ID {} to: {}", id, student);
        return student;
    }
}
