package com.example.IssueTrackerORM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.repository.BugRepository;

@Service
public class BugService {
    @Autowired
    private BugRepository bugRepository;

    public List<Bug> getallbugs(){
        return bugRepository.findAll();
    }

    public List<Bug> findByStatus(String status){
        return bugRepository.findByStatus(status);
    }

    // public List<Bug> findByPriorityOrderByCreatedDateDesc(String priority){
    //     return bugRepository.findByPriorityOrderByCreatedDateDesc(priority);
    // }

    public List<Bug> findByProjectId(int projectId){
        return bugRepository.findByProjectId(projectId);
    }

    public List<Bug> findByAssignedToId(int userId){
        return bugRepository.findByAssignedToId(userId);
    }

    public List<Bug> findUnresolvedBugByUserId(int userId) {
        return bugRepository.findUnresolvedBugByUserId(userId);
    }
    public long countByProjectId(int projectId) {
        return bugRepository.countByProjectId(projectId);
    }
    



}
