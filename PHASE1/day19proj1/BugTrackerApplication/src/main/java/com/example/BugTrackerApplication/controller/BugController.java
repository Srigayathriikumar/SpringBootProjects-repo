package com.example.BugTrackerApplication.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.BugTrackerApplication.dto.BugResponseDTO;
import com.example.BugTrackerApplication.service.BugService;
import com.example.BugTrackerApplication.entity.Bug;
@RestController
@RequestMapping("/api/bugs")
public class BugController {
    @Autowired
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @GetMapping
    public List<BugResponseDTO> getAllBugs() {
        return bugService.getAllBugs();
    }

    //accessible only by admin
    @PostMapping("/admin")
    public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
        Bug createdBug = bugService.createBug(bug);
        return ResponseEntity.ok(createdBug);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteBug(@PathVariable Long id) {
        bugService.deleteBug(id);
        return ResponseEntity.ok("Bug deleted successfully");
    }

    @GetMapping("/{status}/{assignee}/{project}")
    public List<BugResponseDTO> getfilterbugs(@PathVariable String status, @PathVariable String assignee, @PathVariable String project) {
        return bugService.filterBugs(status, assignee, project);
     }

    @GetMapping("/status/{status}")
    public List<BugResponseDTO> getBugsByStatus(@PathVariable String status) {
        return bugService.filterbystatus(status);
    }
    @GetMapping("/assignee/{assignee}")
    public List<BugResponseDTO> getBugsByAssignee(@PathVariable String assignee) {
        return bugService.filterbyassignee(assignee);
    }

    @GetMapping("/project/{project}")
    public List<BugResponseDTO> getBugsByProject(@PathVariable String project) {
        return bugService.filterbyproject(project);
    }
}
