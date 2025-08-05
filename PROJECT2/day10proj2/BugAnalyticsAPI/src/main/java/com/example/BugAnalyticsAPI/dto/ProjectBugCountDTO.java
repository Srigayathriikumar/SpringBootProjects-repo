package com.example.BugAnalyticsAPI.dto;

public class ProjectBugCountDTO {
   private Long projectId;
    private String projectName;
    private Long bugCount;

    
    
    public ProjectBugCountDTO(Long projectId,Long bugCount) {
        this.projectId = projectId;
        this.bugCount = bugCount;
    }
    public ProjectBugCountDTO(String projectName, Long bugCount) {
        this.projectName = projectName;
        this.bugCount = bugCount;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public Long getBugCount() {
        return bugCount;
    }
    public void setBugCount(Long bugCount) {
        this.bugCount = bugCount;
    }

    @Override
public String toString() {
    return "ProjectBugCountDTO{" +
            "projectName='" + projectName + '\'' +
            ", bugCount=" + bugCount +
            '}';
}
}


