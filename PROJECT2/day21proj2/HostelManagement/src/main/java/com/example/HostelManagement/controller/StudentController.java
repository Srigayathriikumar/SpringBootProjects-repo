package com.example.HostelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;



import java.util.List;

import com.example.HostelManagement.domain.Student;
import com.example.HostelManagement.dto.StudentResponseDTO;
import com.example.HostelManagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER') or hasRole('USER')")
    public Page<StudentResponseDTO> getAllStudents(Pageable pageable) {
        return studentService.getAllStudents(pageable);
    }

    @PostMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER')")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    @GetMapping("/{roomno}/{assignedto}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER') or hasRole('USER')")
    public List<StudentResponseDTO> getFilteredStudents(@PathVariable Long roomno, @PathVariable String assignedto) {
        return studentService.getfilter(roomno, assignedto);
    }

    @GetMapping("/room/{roomno}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER') or hasRole('USER')")
    public List<StudentResponseDTO> getStudentsByRoomNo(@PathVariable Long roomno) {
        return studentService.getfilterbyroomno(roomno);
    }

    @GetMapping("/staff/{assignedto}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('DEVELOPER') or hasRole('USER')")
    public List<StudentResponseDTO> getStudentsByStaff(@PathVariable String assignedto) {
        return studentService.getfilterbystaff(assignedto);
    }
}
