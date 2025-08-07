package com.example.IssueTrackerORM.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "bugs")

public class Bug {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message="Id not be null")
    private Long id;
    @NotBlank(message="title not be blank")
    @Size(min=3,max=20,message="should be between 3 to 20 letters")
    private String title;
    @NotBlank(message="description should not be blank")
    private String description;
    @NotBlank(message="must not be empty")
    @Pattern(regexp = "^(opened|closed|found)$", message = "Status must be 'opened', 'closed', or 'found'")
    private String status;
    @NotBlank(message="Bug priority is required")
    private String priority;

    @ManyToOne
    @JoinColumn(name = "assignedto")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    public Bug() {
    }
    public Bug(String titleString, String descriptionString, String statusString, String priorityString, Long project_id, Long userId) {
        this.title = titleString;
        this.description = descriptionString;
        this.status = statusString;
        this.priority = priorityString;
        this.project = new Project(project_id);
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
    public String getProjectName() {
    return project != null ? project.getProjname() : null;
}
    public void setProjectName(String projectName) {
    if (this.project == null) {
        this.project = new Project();
    }
    this.project.setProjname(projectName);
}
    public long getProjectId() {
        return project.getId();
    }
    public void setProjectId(Long project_id) {
        this.project = new Project(project_id);
    }
    public Bug getProject(Bug project) {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public  Bug getAssignedTo(Bug assignedTo) {
        return assignedTo;
    }
}
