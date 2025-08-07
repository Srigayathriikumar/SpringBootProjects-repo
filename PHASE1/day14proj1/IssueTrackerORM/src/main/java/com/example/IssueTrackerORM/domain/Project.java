package com.example.IssueTrackerORM.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.*;
@Entity
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message="id not be null")
    private  Long id;
    @NotBlank(message="project name should not be empty")
    private String projname;

    
    public Project() {
       
    }

    public Project(Long projectId) {
        //TODO Auto-generated constructor stub
    }

    @OneToMany(mappedBy = "project")
    private List<Bug> bugs;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public List<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    

}
