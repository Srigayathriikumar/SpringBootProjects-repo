package com.example.BugTrackerApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BugTrackerApplication.dto.BugResponseDTO;
import com.example.BugTrackerApplication.repository.BugRepository;

@Service
public class BugService {
    @Autowired
    private final BugRepository bugRepository;

    public BugService(BugRepository bugRepository){
        this.bugRepository=bugRepository;
    }

    // LINQ for filter
    public List<BugResponseDTO> filterBugs(String status,String assignee,String project){
        return bugRepository.findAll().stream()
        .filter(b->status==null ||b.getStatus().equalsIgnoreCase(status))
        .filter(b->assignee==null || b.getAssignee().equalsIgnoreCase(assignee))
        .filter(b->project==null || b.getProject().equalsIgnoreCase(project))
        .map(b->new BugResponseDTO(b.getId(),b.getTitle(),b.getStatus(),b.getAssignee(),b.getProject()))
        .collect(Collectors.toList());
    }

    public List<BugResponseDTO> filterbystatus(String status){
        return bugRepository.findAll().stream()
        .filter(b->status==null || b.getStatus().equalsIgnoreCase(status))
        .map(b->new BugResponseDTO(b.getId(),b.getTitle(),b.getStatus(),b.getAssignee(),b.getProject()))
        .collect(Collectors.toList());
    }

    public List<BugResponseDTO> filterbyassignee(String assignee){
        return bugRepository.findAll().stream()
        .filter(b->assignee==null || b.getAssignee().equalsIgnoreCase(assignee))
        .map(b->new BugResponseDTO(b.getId(),b.getTitle(),b.getStatus(),b.getAssignee(),b.getProject()))
        .collect(Collectors.toList());
     }

    public List<BugResponseDTO> filterbyproject(String project){
        return bugRepository.findAll().stream()
        .filter(b->project==null || b.getProject().equalsIgnoreCase(project))
        .map(b->new BugResponseDTO(b.getId(),b.getTitle(),b.getStatus(),b.getAssignee(),b.getProject()))
        .collect(Collectors.toList());
    }
}
