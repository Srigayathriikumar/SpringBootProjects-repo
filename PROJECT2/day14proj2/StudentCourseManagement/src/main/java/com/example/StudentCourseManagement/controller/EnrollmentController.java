package com.example.StudentCourseManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.StudentCourseManagement.domain.Course;
import com.example.StudentCourseManagement.domain.Enrollment;
import com.example.StudentCourseManagement.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/all")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }
    @PostMapping("/create")
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }
    @GetMapping("/courses/{studentId}")
    public List<Course> viewCoursesByStudent(@PathVariable Long studentId) {
        return enrollmentService.viewCoursesByStudent(studentId);
    }
    
}
