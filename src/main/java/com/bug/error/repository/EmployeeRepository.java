package com.bug.error.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.error.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findByUsername(String username);

}
