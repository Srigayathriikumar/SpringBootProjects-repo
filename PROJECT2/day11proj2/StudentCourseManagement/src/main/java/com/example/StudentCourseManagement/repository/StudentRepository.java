package com.example.StudentCourseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCourseManagement.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findByEmail(String email);
    void deleteById(Long id);
}
