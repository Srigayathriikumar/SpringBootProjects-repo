package com.example.StudentCourseManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.StudentCourseManagement.domain.Enrollment;
import com.example.StudentCourseManagement.domain.Student;
import com.example.StudentCourseManagement.repository.EnrollmentRepository;
import com.example.StudentCourseManagement.repository.StudentRepository;

import jakarta.transaction.Transactional;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(name);
        student.setEmail(email);
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public void deleteStudent(Long id) {
        enrollmentRepository.deleteByStudentId(id);
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
    
}
