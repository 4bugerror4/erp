package com.bug.error.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bug.error.entity.Employee;
import com.bug.error.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalUserDetailsService implements UserDetailsService {
	
	private final EmployeeService employeeService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = employeeService.getEmployee(username);
		
		return new PrincipalUserDetails(employee);
	}

}
