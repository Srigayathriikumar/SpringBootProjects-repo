package com.example.IssueTrackerORM.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.repository.BugRepository;

import jakarta.transaction.Transactional;

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

    public List<Bug> findUnresolvedBugByUserId() {
        return bugRepository.findUnresolvedBugByUserId();
    }
    public long countByProjectId(int projectId) {
        return bugRepository.countByProjectId(projectId);
    }
    public Bug createBug(Bug bug) {
        
        return bugRepository.save(bug);
    }
    @Transactional
    public void deletebug(Long bugId) {
        bugRepository.deleteById(bugId);
    }
    @Transactional
    public Bug updatebugstatus(Long bugId,String status){
        Bug bug = bugRepository.findById(bugId).orElseThrow(() -> new RuntimeException("Bug not found"));
        bug.setStatus(status);
        return bugRepository.save(bug);

    }
}
