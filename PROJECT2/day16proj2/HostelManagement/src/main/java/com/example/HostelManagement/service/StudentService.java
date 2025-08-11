package com.example.HostelManagement.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import com.example.HostelManagement.domain.Room;
import com.example.HostelManagement.domain.Staff;
import com.example.HostelManagement.domain.Student;
import com.example.HostelManagement.repository.RoomRepository;
import com.example.HostelManagement.repository.StaffRepository;
import com.example.HostelManagement.dto.StudentResponseDTO;
import com.example.HostelManagement.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StaffRepository staffRepository;

    public List<StudentResponseDTO> getfilter(Long roomno, String assignedto) {
        boolean roomExists = roomRepository.existsByRoomNumber(roomno);
        boolean staffExists = staffRepository.existsByName(assignedto);

        if (!roomExists && !staffExists) {
            System.out.println("Room or Staff does not exist");
            return Collections.emptyList();
            
        }

        return studentRepository.findAll().stream()
                .filter(b ->roomno == null || b.getRoomno().equals(roomno))
                .filter(b->assignedto == null || b.getAssigneedto().equalsIgnoreCase(assignedto))
                .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getRoomno(), student.getAssigneedto()))
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getfilterbyroomno(Long roomno) {
        boolean roomExists = roomRepository.existsByRoomNumber(roomno);
        if (!roomExists) {
            System.out.println("Room does not exist");
            return Collections.emptyList();
        }

        return studentRepository.findAll().stream()
                .filter(b -> roomno == null || b.getRoomno().equals(roomno))
                .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getRoomno(), student.getAssigneedto()))
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getfilterbystaff(String assignedto) {
        boolean staffExists = staffRepository.existsByName(assignedto);
        if (!staffExists) {
            System.out.println("Staff does not exist");
            return Collections.emptyList();
        }

        return studentRepository.findAll().stream()
                .filter(b -> assignedto == null || b.getAssigneedto().equalsIgnoreCase(assignedto))
                .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getRoomno(), student.getAssigneedto()))
                .collect(Collectors.toList());
    }
}
