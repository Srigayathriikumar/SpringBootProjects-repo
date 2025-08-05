package com.example.BugAnalyticsAPI.repository;
import com.example.BugAnalyticsAPI.entity.Project;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.name = ?1")
    Project findByName(String name);

    @Query("SELECT p FROM Project p WHERE p.id = ?1")
    Optional<Project> findById(Long id);

    @Query("SELECT p FROM Project p")
    List<Project> findAllProjects();
}
