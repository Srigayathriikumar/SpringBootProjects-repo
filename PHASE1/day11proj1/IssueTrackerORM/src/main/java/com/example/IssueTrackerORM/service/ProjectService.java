package com.example.IssueTrackerORM.service;
import java.util.List;


import com.example.IssueTrackerORM.domain.Project;
public interface ProjectService {
    // @Autowired
    // private ProjectRepository projectRepository;

    public List<Project> getAllProjects() ;
    Project getProjectById(int id);
    Project createProject(Project project);
    Project updateProject(int id, String projname);
    void deleteProject(int id);
    
}
