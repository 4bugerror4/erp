package com.bug.error.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bug.error.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrincipalUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Employee employee;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> auth = new ArrayList<>();
		
		auth.add(new GrantedAuthority() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				
				return employee.getRole();
			}
		});
		
		return auth;
	}

	@Override
	public String getPassword() {

		return employee.getPassword();
	}

	@Override
	public String getUsername() {

		return employee.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
