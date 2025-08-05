package com.example.BugAnalyticsAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.BugAnalyticsAPI.entity.Bug;
import com.example.BugAnalyticsAPI.repository.BugRepository;
import com.example.BugAnalyticsAPI.dto.PriorityCountDTO;
import com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO;
import com.example.BugAnalyticsAPI.dto.StatusCountDTO;
import com.example.BugAnalyticsAPI.repository.ProjectRepository;

@Service
public class BugServiceImpl implements BugService {
    @Autowired
    private BugRepository bugRepository;

    @Override
    public void createBug(String projectName, String description) {
       
        Bug bug = new Bug(projectName, description);
       bugRepository.save(bug);
    }
    @Override
    public void updateBug(Long bugId, String description) {
        Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new RuntimeException("Bug not found"));
        bug.setDescription(description);
        bugRepository.save(bug);
    }
    @Override
    public void deleteBug(Long bugId) {
        Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new RuntimeException("Bug not found"));
        bugRepository.delete(bug);
    }
    @Override
    public ProjectBugCountDTO getBugCountByProject(String projectName) {
        if (projectName == null || projectName.isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty");
        }
        
        Long bugCount = bugRepository.countBugsByProjectName(projectName);
        return new ProjectBugCountDTO(projectName, bugCount);
    }

    public List<PriorityCountDTO> countBugsByPriority() {
        return bugRepository.countBugsByPriority();
    }

    public List<ProjectBugCountDTO> countBugsByProject() {
        return bugRepository.countBugsByProject();
    }

    public List<StatusCountDTO> countBugsByStatus() {
        return bugRepository.countBugsByStatus();
    }
    public List<ProjectBugCountDTO> findTop3ProjectsWithMostBugs() {
        Pageable pageable = PageRequest.of(0, 3);
        return bugRepository.findTop3ProjectsWithMostBugs(pageable);
    }

    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }
    
   
   
    }
    

