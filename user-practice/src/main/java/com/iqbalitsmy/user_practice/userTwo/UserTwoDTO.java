package com.iqbalitsmy.user_practice.userTwo;

import java.time.LocalDateTime;

public class UserTwoDTO {
	private Long id;
	private String email;
	private String name;
	private String roll;
	private LocalDateTime createdAt;
	
	
	public UserTwoDTO() {
	}

	public UserTwoDTO(Long id, String email, String name, String roll, LocalDateTime createdAt) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.roll = roll;
		this.createdAt = createdAt;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getRoll() {
		return roll;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
