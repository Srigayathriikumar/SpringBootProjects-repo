package com.example.IssueTrackerORM.domain;

import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
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
