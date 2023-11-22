package ModelTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
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

import com.Darden.Services.StudentServices;
import com.Darden.models.Student;
import com.Darden.repo.StudentRepo;


 
public class StudentServicesTest {
 
    @Mock
    private StudentRepo studentRepository; // Assuming you have a StudentRepository
 
    @InjectMocks
    private StudentServices studentService;
 
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testAddStudent() {
        Student student = new Student(/* Provide necessary details */);
        // Mocking behavior
        when(studentRepository.save(student)).thenReturn(student);
        Student savedStudent = studentService.addStudent(student);
 
        assertEquals(student, savedStudent);
        verify(studentRepository, times(1)).save(student);
    }
 
    @Test
    public void testGetStudents() {
        // Create sample data for testing
        List<Student> students = Arrays.asList(new Student(/* details */), new Student(/* details */));
        // Mocking behavior
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> result = studentService.getStud();
 
        assertEquals(students.size(), result.size());
        // Add further assertions based on your logic
        verify(studentRepository, times(1)).findAll();
    }
 
    @Test
    public void testDeleteStudent() {
        int studentIdToDelete = 1;
        // Mocking behavior
        doNothing().when(studentRepository).deleteById(studentIdToDelete);
        studentService.del_Stud(studentIdToDelete);
 
        verify(studentRepository, times(1)).deleteById(studentIdToDelete);
    }
 
    @Test
    public void testUpdateStudent() {
        int studentIdToUpdate = 1;
        Student student = new Student();
 
        // Mocking behavior
        when(studentRepository.save(student)).thenReturn(student);
        Student updatedStudent = studentService.updt_Stud(student, studentIdToUpdate);
 
        assertEquals(student, updatedStudent);
        verify(studentRepository, times(1)).save(student);
    }
}