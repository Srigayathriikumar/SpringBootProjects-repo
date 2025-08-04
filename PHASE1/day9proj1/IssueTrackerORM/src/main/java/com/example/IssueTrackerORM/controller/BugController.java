package com.example.IssueTrackerORM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    @Autowired
    private BugService bugService;

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getallbugs();
    }

    @GetMapping("/status/{status}")
    public List<Bug> getBugsByStatus(@PathVariable String status) {
        return bugService.findByStatus(status);
    }

    @GetMapping("/user/{userId}/open")
    public List<Bug> getUnresolvedBugsByUserId(@PathVariable int userId) {
        return bugService.findUnresolvedBugByUserId(userId);
    }

    @GetMapping("/project/{projectId}")
    public List<Bug> getBugsByProjectId(@PathVariable int projectId) {
        return bugService.findByProjectId(projectId);
    }

    @GetMapping("/assigned/{userId}")
    public List<Bug> getBugsAssignedToUser(@PathVariable int userId) {
        return bugService.findByAssignedToId(userId);
    }

    @GetMapping("/count/{projectId}")
    public long countBugsByProjectId(@PathVariable int projectId) {
        return bugService.countByProjectId(projectId);
    }
}
