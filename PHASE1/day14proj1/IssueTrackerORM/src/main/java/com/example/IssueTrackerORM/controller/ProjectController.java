package com.example.IssueTrackerORM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

   @PostMapping("/create")
public Project createProject(@Valid @RequestBody Project project) {
    return projectService.createProject(project);
}

    @PutMapping("/update/{id}/{projname}")
    public Project updateProject(@Valid @PathVariable("id") int id, @PathVariable("projname") String projname) {
        if (projname == null || projname.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project name cannot be empty.");
        }
        return projectService.updateProject(id, projname);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProject(@PathVariable int id) {
        
        projectService.deleteProject(id);
        return "Project with ID " + id + " deleted successfully.";
    }
}
