package com.example.StudentCourseManagement.service;
import com.example.StudentCourseManagement.domain.Course;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course createcourse(Course course);
    Course updatecourse(Long id, String title,String description);
    void deletecourse(Long id);
    Course getCourseById(Long id);
    
} 
