package com.example.StudentCourseManagement.controller;
import java.util.*;

import com.example.StudentCourseManagement.domain.Course;
import com.example.StudentCourseManagement.service.CourseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @PostMapping("/create")
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.createcourse(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@Valid @PathVariable Long id, @RequestBody Course course) {
        return courseService.updatecourse(id, course.getTitle(), course.getDescription());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deletecourse(id);
        return ResponseEntity.ok("Course " + id + " deleted successfully");
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

}
