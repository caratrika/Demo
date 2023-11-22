package com.Darden.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Darden.Services.StudentServices;
import com.Darden.models.Student;

 
 
@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentControllers {
 
	@Autowired
	private StudentServices studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		studentService.addStudent(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@GetMapping("/GetStudents")
	public List<Student> getStudent(){
		return studentService.getStud();
	}
	
	@DeleteMapping("/deleteStudents/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentService.del_Stud(id);
		return "Student deleted";
	}
	
	@PutMapping("/updateStudents/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		return  studentService.updt_Stud(student,id);
	}
	
}
 
 