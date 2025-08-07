package com.example.IssueTrackerORM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BugRequestDTO {
    @NotBlank(message="Bug title is required")
    @Size(min = 3, max = 10, message = "Bug title must be between 3 and 10 characters")
    private String title;

    @NotBlank(message="should be within 3 to 10")
    private String description;

    @NotBlank(message="must not be empty")
    @Pattern(regexp = "^(opened|closed|found)$", message = "Status must be 'opened', 'closed', or 'found'")
    private String status;
    @NotBlank(message="Bug priority is required")
    private String priority;

    @NotNull
    private Long project_id;

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

    public Long getProjectId() {
        return project_id;
    }

    public void setProjectId(Long project_id) {
        this.project_id = project_id;
    }


}
