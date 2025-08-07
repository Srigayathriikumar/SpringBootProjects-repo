package com.example.StudentCourseManagement.mapper;

import com.example.StudentCourseManagement.domain.Student;
import com.example.StudentCourseManagement.dto.StudentRequestDTO;
import com.example.StudentCourseManagement.dto.StudentResponseDTO;

public class StudentMapper {
    public static Student toEntity(StudentRequestDTO dto) {
    Student student = new Student();
    student.setId(dto.getId());
    student.setName(dto.getName());
    student.setEmail(dto.getEmail());
    return student;
}

    public static StudentResponseDTO toResponse(Student student) {
    StudentResponseDTO dto = new StudentResponseDTO();
    dto.setId(student.getId());
    dto.setName(student.getName());
    dto.setEmail(student.getEmail());
    return dto;
}
}
