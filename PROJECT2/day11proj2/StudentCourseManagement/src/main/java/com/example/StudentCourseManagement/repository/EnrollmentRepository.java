package com.example.StudentCourseManagement.repository;
import com.example.StudentCourseManagement.domain.Enrollment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
    void deleteById(Long id);
    void deleteByStudentId(Long studentId);
    void deleteByCourseId(Long courseId);
    List<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
