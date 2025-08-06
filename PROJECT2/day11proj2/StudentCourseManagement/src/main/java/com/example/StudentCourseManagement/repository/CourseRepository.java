package com.example.StudentCourseManagement.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCourseManagement.domain.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitle(String title);
    Optional<Course> findById(Long id);
    void deleteById(Long id);
    
}
