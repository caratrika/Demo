package com.Darden.Services;


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Darden.models.Student;
import com.Darden.repo.StudentRepo;
	 
	 
	 
	@Service
	public class StudentServices {
	 
		@Autowired
		private StudentRepo repo;
		
	 
		public Student addStudent(Student student) {
			repo.save(student);
			return student;
		}
	 
		public List<Student> getStud() {
			return repo.findAll();
		}
	 
		public void del_Stud(int id) {
			repo.deleteById(id);
			
		}
	 
		public Student updt_Stud(Student Student, int id) {
			repo.deleteById(id);
			repo.save(Student);
			return Student;
			
		}
		
}
