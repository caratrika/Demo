package ModelTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.Darden.models.Student;
 
 
public class TestStudent {
	
	 	@Test
	    public void testStudentDetails() {
	        Student student = new Student();
	        student.setStudentName("Alice");
	        student.setAge(20);
	        student.setSalary(50000);
 
	        Assertions.assertEquals("Alice", student.getStudentName());
	        Assertions.assertEquals(20, student.getAge());
	        Assertions.assertEquals(50000, student.getSalary());
	    }
 
}
 