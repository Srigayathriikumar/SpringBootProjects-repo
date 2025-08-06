package com.example.IssueTrackerORM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.dto.BugRequestDTO;
import com.example.IssueTrackerORM.dto.BugResponseDTO;
import com.example.IssueTrackerORM.mapper.BugMapper;
import com.example.IssueTrackerORM.service.BugService;
import com.example.IssueTrackerORM.service.ProjectService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    @Autowired
    private BugService bugService;

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<BugResponseDTO> getAllBugs() {
        List<BugResponseDTO> list = new ArrayList<>();
        for(Bug bug:bugService.getallbugs()){
            list.add(BugMapper.toResponse(bug));
        }
        return list;
    }

    @PostMapping
    public Bug requestbug(@RequestBody BugRequestDTO bugrequestdto){
        Project project = projectService.getProjectById(bugrequestdto.getProjectId());
    if(project == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
    }
    Bug bug = BugMapper.toEntity(bugrequestdto, project);
    return bugService.createBug(bug);
    }

    @GetMapping("/status/{status}")
    public List<Bug> getBugsByStatus(@PathVariable String status) {
        return bugService.findByStatus(status);
    }

    @GetMapping("/user/open")
    public List<Bug> getUnresolvedBugsByUserId( ) {
        if(bugService.findUnresolvedBugByUserId() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unresolved bugs found for the user.");
        }
        return bugService.findUnresolvedBugByUserId();
    }

    @GetMapping("/project/{projectId}")
    public List<Bug> getBugsByProjectId(@PathVariable int projectId) {
        return bugService.findByProjectId(projectId);
    }

    @GetMapping("/assigned/{userId}")
    public List<Bug> getBugsAssignedToUser(@PathVariable int userId) {
        if (bugService.findByAssignedToId(userId) == null || bugService.findByAssignedToId(userId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bugs assigned to user with ID: " + userId);
        }
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
