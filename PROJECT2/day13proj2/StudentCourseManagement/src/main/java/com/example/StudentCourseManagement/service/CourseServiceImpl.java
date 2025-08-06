package com.example.StudentCourseManagement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudentCourseManagement.repository.CourseRepository;
import com.example.StudentCourseManagement.repository.EnrollmentRepository;

import jakarta.transaction.Transactional;

import com.example.StudentCourseManagement.domain.Course;
@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
     private CourseRepository courseRepository;

     @Autowired
        private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createcourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public Course updatecourse(Long id, String title, String description) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(title);
        course.setDescription(description);
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public void deletecourse(Long id) {
        enrollmentRepository.deleteByCourseId(id);
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));

    }

}
