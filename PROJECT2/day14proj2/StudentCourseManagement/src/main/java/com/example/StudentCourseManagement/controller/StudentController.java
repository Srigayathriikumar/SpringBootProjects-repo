package com.example.StudentCourseManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.StudentCourseManagement.domain.Student;
import com.example.StudentCourseManagement.dto.StudentRequestDTO;
import com.example.StudentCourseManagement.dto.StudentResponseDTO;
import com.example.StudentCourseManagement.mapper.StudentMapper;
import com.example.StudentCourseManagement.service.StudentService;

import jakarta.validation.Valid;

import java.util.*;
@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> responseStudent(){
        List<StudentResponseDTO> list=new ArrayList<>();
        for(Student student:studentService.getAllStudents()){
            list.add(StudentMapper.toResponse(student));
        }
        return list;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student requestStudent(@Valid @RequestBody StudentRequestDTO studentrequestdto){
    return studentService.createStudent(StudentMapper.toEntity(studentrequestdto));
    }

    
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestParam String name, @RequestParam String email) {
        return studentService.updateStudent(id, name, email);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student "+id+" deleted successfully");
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
