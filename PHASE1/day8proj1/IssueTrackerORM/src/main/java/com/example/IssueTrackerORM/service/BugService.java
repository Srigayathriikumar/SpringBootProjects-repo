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
}
