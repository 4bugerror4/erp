package com.bug.error.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String phone;
	
	@Column(nullable = false, length = 50)
	private String address;
	
	@Column(nullable = false, length = 10)
	private String role;
	
	@Column(nullable = false, length = 10)
	private String erank;
	
	@Column(nullable = false, length = 100)
	private String department;

}
