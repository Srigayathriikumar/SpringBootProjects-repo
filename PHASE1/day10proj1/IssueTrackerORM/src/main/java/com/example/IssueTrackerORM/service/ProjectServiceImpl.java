package com.example.IssueTrackerORM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.repository.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int id) {
        return projectRepository.findById((long) id).orElse(null);
    }
    @Override
    public Project createProject(Project project) {
        Project newProject = new Project();
       
        newProject.setId(project.getId());
        newProject.setProjname(project.getProjname());
        
        
        return projectRepository.save(newProject);
    }
    // @Override
    // public Project updateProject(int id, Project project) {
    //     if (projectRepository.existsById((long) id)) {
    //         project.setId((long) id);
    //         return projectRepository.save(project);
    //     }
    //     return null; 
    // }
    
}
