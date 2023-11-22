package ModelTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Darden.Controllers.StudentControllers;
import com.Darden.Services.StudentServices;
import com.Darden.models.Student;


 
public class StudentControllerTest {
 
    @Mock
    private StudentServices studentService;
 
    @InjectMocks
    private StudentControllers studentController;
 
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testAddStudent() {
        Student student = new Student(/* Provide necessary details */);
        // Mocking behavior
        when(studentService.addStudent(student)).thenReturn(student);
        ResponseEntity<Student> response = studentController.addStudent(student);
 
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).addStudent(student);
    }
 
    @Test
    public void testGetStudents() {
        List<Student> students = Arrays.asList(new Student(/* details */), new Student(/* details */));
        // Mocking behavior
        when(studentService.getStud()).thenReturn(students);
        List<Student> result = studentController.getStudent();
 
        assertEquals(students.size(), result.size());
        // Add further assertions based on your logic
        verify(studentService, times(1)).getStud();
    }
 
    @Test
    public void testDeleteStudent() {
        int studentIdToDelete = 1;
        String response = studentController.deleteStudent(studentIdToDelete);
 
        assertEquals("Student deleted", response);
        verify(studentService, times(1)).del_Stud(studentIdToDelete);
    }
 
    @Test
    public void testUpdateStudent() {
        int studentIdToUpdate = 1;
        Student student = new Student(/* details */);
 
        // Mocking behavior
        when(studentService.updt_Stud(student, studentIdToUpdate)).thenReturn(student);
        Student updatedStudent = studentController.updateStudent(student, studentIdToUpdate);
 
        assertEquals(student, updatedStudent);
        verify(studentService, times(1)).updt_Stud(student, studentIdToUpdate);
    }
}