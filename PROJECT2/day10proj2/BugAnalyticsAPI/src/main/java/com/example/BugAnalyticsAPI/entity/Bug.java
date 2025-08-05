package com.example.BugAnalyticsAPI.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bugs")
public class Bug {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private String assignedto;
    private String priority;

    @ManyToOne
@JoinColumn(name = "project_id")
private Project project;
    // @ManyToOne
    // @JoinColumn(name = "project_id", nullable = false)
    // private Project project;
    public Bug() {
    }
    public Bug(String projectName, String description) {
        //TODO Auto-generated constructor stub
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
    public String getAssignedto() {
        return assignedto;
    }
    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }
   
   
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // public Project getProject() {
    //     return project;
    // }

    // public void setProject(Project project) {
    //     this.project = project;
    // }

    
}

