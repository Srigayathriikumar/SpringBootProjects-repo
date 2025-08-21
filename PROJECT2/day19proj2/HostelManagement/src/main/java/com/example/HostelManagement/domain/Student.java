package com.example.HostelManagement.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Long roomno;
    private String assigneedto;

    public Student() {
    }
    public Student(Long id, String name, Long roomno, String assigneedto) {
        this.id = id;
        this.name = name;
        this.roomno = roomno;
        this.assigneedto = assigneedto;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getRoomno() {
        return roomno;
    }
    public void setRoomno(Long roomno) {
        this.roomno = roomno;
    }
    public String getAssigneedto() {
        return assigneedto;
    }
    public void setAssigneedto(String assigneedto) {
        this.assigneedto = assigneedto;
    }
    
}
