package com.iqbalitsmy.user_practice.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
	@NotBlank(message= "Name is required")
	private String username;
	
	@Email(message= "Must be a valid email")
	@NotBlank(message= "Email is required")
	private String email;
	
	@NotBlank(message= "Password is required")
	@Size(min = 8, message= "Password must be at least 8 characters")
	private String password;
	
	public CreateUserRequest() {
	}

	public CreateUserRequest(@NotBlank(message = "Name is required") String username,
			@Email(message = "Must be a valid email") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be at least 8 characters") String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
