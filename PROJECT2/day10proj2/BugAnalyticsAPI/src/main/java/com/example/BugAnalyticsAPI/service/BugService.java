package com.example.BugAnalyticsAPI.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO;

public interface BugService {
    
    void createBug(String projectName, String description);
    void updateBug(Long bugId, String description);
    void deleteBug(Long bugId);
    ProjectBugCountDTO getBugCountByProject(String projectName);
    Object countBugsByStatus();
    Object countBugsByPriority();

}
