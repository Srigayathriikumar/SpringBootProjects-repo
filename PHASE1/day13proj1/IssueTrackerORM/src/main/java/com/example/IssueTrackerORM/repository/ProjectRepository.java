package com.example.IssueTrackerORM.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.IssueTrackerORM.domain.Project;
public interface ProjectRepository extends JpaRepository<Project, Long> {
 List<Project> findByProjname(String projname);
 List<Project> findByIdIn(List<Long> ids);
 
 @Query("SELECT p FROM Project p JOIN p.bugs b WHERE b.id = ?1")
    List<Project> findByBugsId(Long bugId);

  
}
