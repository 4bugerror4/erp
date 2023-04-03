package com.bug.error.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.error.entity.Employee;
import com.bug.error.entity.dto.EmployeeDeleteDto;
import com.bug.error.entity.dto.EmployeeSaveDto;
import com.bug.error.entity.dto.EmployeeUpdateDto;
import com.bug.error.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeApiController {
	
	private final EmployeeService employeService;
	
	@PostMapping("/employee/save")
	public Employee save(@RequestBody EmployeeSaveDto dto) {
		
		Employee employee = employeService.save(dto.toEntity());
		
		return employee;
	}
	
	@PutMapping("/employee/update")
	public Employee update(@RequestBody EmployeeUpdateDto dto) {
		
		Employee employee = employeService.update(dto.toEntity());
		
		return employee;
	}
	
	@DeleteMapping("/employee/delete")
	public void delete(@RequestBody EmployeeDeleteDto dto) {
		
		employeService.delete(dto.getId());
	}
	
	

}
