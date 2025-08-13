package com.example.HostelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import java.util.List;
import com.example.HostelManagement.dto.StudentResponseDTO;
import com.example.HostelManagement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/search")
    public Page<Void> searchStudents(@RequestParam String name, @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return studentService.searchStudentsMetadata(name, pageable);
    }
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
