package com.example.HostelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.example.HostelManagement.dto.StudentResponseDTO;
import com.example.HostelManagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/{roomno}/{assignedto}")
    public List<StudentResponseDTO> getFilteredStudents(@PathVariable Long roomno, @PathVariable String assignedto) {
        return studentService.getfilter(roomno, assignedto);
    }

    @GetMapping("/room/{roomno}")
    public List<StudentResponseDTO> getStudentsByRoomNo(@PathVariable Long roomno) {
        return studentService.getfilterbyroomno(roomno);
    }

    @GetMapping("/staff/{assignedto}")
    public List<StudentResponseDTO> getStudentsByStaff(@PathVariable String assignedto) {
        return studentService.getfilterbystaff(assignedto);
    }
}
