package com.example.HostelManagement.repository;
import com.example.HostelManagement.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoomRepository extends JpaRepository<Room,Long>{

    boolean existsByRoomNumber(Long roomNumber);
    
} 