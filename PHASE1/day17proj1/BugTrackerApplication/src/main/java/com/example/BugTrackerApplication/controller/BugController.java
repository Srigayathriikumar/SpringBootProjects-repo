package com.example.BugTrackerApplication.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.example.BugTrackerApplication.dto.BugResponseDTO;
import com.example.BugTrackerApplication.service.BugService;
import com.example.BugTrackerApplication.entity.Bug;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
@RestController
@RequestMapping("/api/bugs")
public class BugController {
    @Autowired
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @GetMapping
    public Page<BugResponseDTO> getAllBugs(@PageableDefault(page = 1, size = 10, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {    
           

            return bugService.getAllBugs(pageable);
          
    }

   @GetMapping("/bugsdata")
public Page<BugResponseDTO> getBugs(
    @RequestParam(required = false) String status,
    @RequestParam(required = false) String title,
    @RequestParam(required = false) String assignee,
    @RequestParam(required = false) String project,
    @RequestParam(defaultValue = "1") int page, // Client sends page=1
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "id") String sortBy,
    @RequestParam(defaultValue = "desc") String direction
) {
    Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
    
    Pageable pageable = PageRequest.of(page - 1, size, sort); 
    return bugService.searchBugs(title, status, assignee, project, pageable);
}


    @GetMapping("/search")
public Page<BugResponseDTO> searchBugs(
    @RequestParam(required = false) String title,
    @RequestParam(required = false) String status,
    @RequestParam(required = false) String assignee,
    @RequestParam(required = false) String project,
    @PageableDefault(page = 1, size = 10, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {

    return bugService.searchBugs(title,status, assignee, project, pageable);
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
