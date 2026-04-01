package com.iqbalitsmy.user_practice.userTwo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserUpdateTwoRequest {
	@Email
	private String email;
	
	private String name;
	
	@Size(min = 8, message= "Password must be at least 8 character")
	private String password;
	
	public UserUpdateTwoRequest() {
	}

	public UserUpdateTwoRequest(
			@Email  String email,
			String name,
			@Size(min = 8, message = "Password must be at least 8 character") String password
			) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
