package com.example.HostelManagement.repository;
import com.example.HostelManagement.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StaffRepository extends JpaRepository<Staff,Long>{

    boolean existsByName(String assignedto);

} 
