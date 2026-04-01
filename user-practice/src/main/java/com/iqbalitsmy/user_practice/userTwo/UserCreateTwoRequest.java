package com.iqbalitsmy.user_practice.userTwo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateTwoRequest {
	@Email
	@NotBlank(message="Email is require")
	private String email;
	
	@NotBlank(message="Name is require")
	private String name;
	
	@NotBlank(message= "Password is require")
	@Size(min = 8, message= "Password must be at least 8 character")
	private String password;
	
	public UserCreateTwoRequest() {
	}

	public UserCreateTwoRequest(
			@Email @NotBlank(message = "Email is require") String email,
			@NotBlank(message = "Name is require") String name,
			@NotBlank(message = "Password is require") @Size(min = 8, message = "Password must be at least 8 character") String password
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
