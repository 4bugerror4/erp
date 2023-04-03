package com.bug.error.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.error.entity.Employee;
import com.bug.error.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final BCryptPasswordEncoder encoder;
	
	// 직원 찾기(Id == PK)
	@Transactional(readOnly = true)
	public Employee getEmployee(Long id) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 번호의 직원은 없습니다."));
		
		return employee;
	}
	
	// 직원 찾기(userName)
	@Transactional(readOnly = true)
	public Employee getEmployee(String username) {
		
		Employee employee = employeeRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 직원은 없습니다."));
		
		return employee;
	}
	
	// 직원 추가
	@Transactional
	public Employee save(Employee employee) {
		
		String rawPassword = employee.getPassword();
		String encPassword = encoder.encode(rawPassword);
		employee.setPassword(encPassword);
		
		Employee employeeEntity = employeeRepository.save(employee);
		
		return employeeEntity;
	}
	
	// 직원 수정
	@Transactional
	public Employee update(Employee employee) {
		
		Employee employeeEntity = employeeRepository.findById(employee.getId()).orElseThrow(() -> new IllegalArgumentException("해당 번호의 직원은 존재하지 않습니다."));
		
		String rawPassword = employee.getPassword();
		String encPassword = encoder.encode(rawPassword);
		
		employeeEntity.setPassword(encPassword);
		employeeEntity.setName(employee.getName());
		employeeEntity.setPhone(employee.getPhone());
		employeeEntity.setAddress(employee.getAddress());
		employeeEntity.setRole(employee.getRole());
		employeeEntity.setErank(employee.getErank());
		employeeEntity.setDepartment(employee.getDepartment());
		
		return employeeEntity;
	}
	
	
	// 직원 삭제
	@Transactional
	public void delete(Long id) {
		
		employeeRepository.deleteById(id);
	}

}
