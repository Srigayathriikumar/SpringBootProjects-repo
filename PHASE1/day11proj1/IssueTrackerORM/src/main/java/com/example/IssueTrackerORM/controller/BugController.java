package com.example.IssueTrackerORM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/user/open")
    public List<Bug> getUnresolvedBugsByUserId( ) {
        return bugService.findUnresolvedBugByUserId();
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

@PostMapping("/createbug")
public Bug createBug(@RequestBody Bug bug) {
    
        return bugService.createBug(bug);
    
}
@DeleteMapping("/deletebug/{bugId}")
public ResponseEntity<String> deleteBug(@PathVariable("bugId") Long bugId) {
    
        bugService.deletebug(bugId);
        return ResponseEntity.ok("Bug with ID " + bugId + " deleted successfully.");
}

@PutMapping("/updatebug/{bugId}/{status}")
public Bug updateBug(@PathVariable("bugId") Long bugId,@PathVariable("status") String status) {
    

    return bugService.updatebugstatus(bugId, status);

}
}
