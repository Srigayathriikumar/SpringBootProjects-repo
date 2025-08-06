package com.example.IssueTrackerORM.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.IssueTrackerORM.domain.Bug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByStatus(String status);
    //List<Bug> findByPriorityOrderByCreatedDateDesc(String priority);
    List<Bug> findByProjectId(int projectId);
    List<Bug> findByAssignedToId(int userId);

    @Query("SELECT b FROM Bug b where b.status <> 'closed'")
    List<Bug> findUnresolvedBugByUserId();

    @Query("SELECT COUNT(b) FROM Bug b WHERE b.project.id = :projectId")
    long countByProjectId(@Param("projectId") int projectId);

    // @Query("DELETE FROM Bug b WHERE b.id = :bugId")
    // void deleteById(@Param("bugId") Long bugId);
}
