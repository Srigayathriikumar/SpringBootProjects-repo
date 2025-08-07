package com.example.StudentCourseManagement.service;
import com.example.StudentCourseManagement.domain.Student;
import java.util.List;

public interface StudentService  {
    
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student updateStudent(Long id, String name, String email);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
}
