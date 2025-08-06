package com.example.StudentCourseManagement.service;
import java.util.*;

import com.example.StudentCourseManagement.domain.Course;
import com.example.StudentCourseManagement.domain.Enrollment;

public interface EnrollmentService {
    Enrollment createEnrollment(Enrollment enrollment);
    List<Enrollment> getAllEnrollments(); 
    List<Course> viewCoursesByStudent(Long studentId);
}
