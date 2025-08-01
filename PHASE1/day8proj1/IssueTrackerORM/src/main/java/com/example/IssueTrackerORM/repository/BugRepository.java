package com.example.IssueTrackerORM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IssueTrackerORM.domain.Bug;
public interface BugRepository extends JpaRepository<Bug, Long> {
    
}
