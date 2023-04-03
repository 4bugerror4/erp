package com.bug.error.entity.dto;

import com.bug.error.entity.Employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeSaveDto {
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String role;
	
	private String erank;
	
	private String department;
	
	public Employee toEntity() {
		return Employee.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.phone(phone)
				.address(address)
				.role(role)
				.erank(erank)
				.department(department)
				.build();
	}

}
