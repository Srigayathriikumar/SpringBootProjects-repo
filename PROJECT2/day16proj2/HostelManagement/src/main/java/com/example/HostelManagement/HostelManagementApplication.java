package com.example.HostelManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HostelManagement.domain.*;
import com.example.HostelManagement.repository.*;

@SpringBootApplication
public class HostelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostelManagementApplication.class, args);
	}
@Bean
    public CommandLineRunner loadData(StudentRepository	 studentRepository) {
		return (args) -> {
			studentRepository.save(new Student(null, "John Doe", 101L, "Mr. Smith"));
			studentRepository.save(new Student(null, "Jane Smith", 103L, "Dr. Brown"));
			studentRepository.save(new Student(null, "Alice Johnson", 103L, "Dr. Brown"));
			studentRepository.save(new Student(null, "Bob Brown", 104L, "Ms. Johnson"));
		};
	}
@Bean
	public CommandLineRunner loadStaffData(StaffRepository staffRepository) {
		return (args) -> {
			staffRepository.save(new Staff(null, "Mr. Smith", null));
			staffRepository.save(new Staff(null, "Ms. Johnson", null));
			staffRepository.save(new Staff(null, "Dr. Brown", null));
			staffRepository.save(new Staff(null, "Ms. Davis", null));
		};
	}

	@Bean
	public CommandLineRunner loadRoomData(RoomRepository roomRepository) {
		return (args) -> {
			roomRepository.save(new Room(null, 101L));
			roomRepository.save(new Room(null, 104L));
			roomRepository.save(new Room(null, 103L));
			roomRepository.save(new Room(null, 102L));
		};
	}
}
