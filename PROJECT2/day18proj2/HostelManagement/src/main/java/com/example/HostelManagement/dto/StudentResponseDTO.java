package com.example.HostelManagement.dto;

public class StudentResponseDTO {
    
    private Long id;
    private String name;
    private Long roomno;
    private String assigneedto;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String name, Long roomno, String assigneedto) {
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
