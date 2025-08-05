package com.example.BugAnalyticsAPI.controller;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BugAnalyticsAPI.dto.PriorityCountDTO;
import com.example.BugAnalyticsAPI.dto.ProjectBugCountDTO;
import com.example.BugAnalyticsAPI.dto.StatusCountDTO;
import com.example.BugAnalyticsAPI.entity.Bug;
import com.example.BugAnalyticsAPI.repository.BugRepository;
import com.example.BugAnalyticsAPI.service.BugService;

@RestController
@RequestMapping("/api/analytics")
public class BugController {
    @Autowired
    private BugService bugService;

    @Autowired
    private BugRepository bugRepository;

    @GetMapping("/test")
    public List<Bug> test() {
        return bugRepository.findAllBugs();
    }
    @GetMapping
    public List<Bug> getAllBugs() {
        try {
            return bugRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching bugs: " + e.getMessage());
        }
    }

    @GetMapping("bugs-by-project/{projectName}")
    public String getBugCountByProject(@PathVariable String projectName) {
        try {
            return bugService.getBugCountByProject(projectName).toString();
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("bugs-by-status")
    public List<StatusCountDTO> countBugsByStatus() {
    return bugRepository.countBugsByStatus();
}

    @GetMapping("bugs-by-priority")
    public List<PriorityCountDTO> countBugsByPriority() {
        return bugRepository.countBugsByPriority();
    }

    @GetMapping("top-projects")
    public List<ProjectBugCountDTO> getTopProjects() {
        return bugRepository.findTop3ProjectsWithMostBugs(PageRequest.of(0, 3));
    }

}
