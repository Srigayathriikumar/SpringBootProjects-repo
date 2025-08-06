package com.example.IssueTrackerORM.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "bugs")

public class Bug {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "assignedto")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    public Bug() {
    }
    public Bug(String titleString, String descriptionString, String statusString, String priorityString, Long projectId, Long userId) {
        this.title = titleString;
        this.description = descriptionString;
        this.status = statusString;
        this.priority = priorityString;
        this.project = new Project(projectId);
        this.assignedTo = new User(userId);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }    

    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public Bug getProject(Bug project) {
        return project;
    }
    public  Bug getAssignedTo(Bug assignedTo) {
        return assignedTo;
    }
}
