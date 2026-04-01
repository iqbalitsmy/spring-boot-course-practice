package com.iqbalitsmy.user_practice.userTwo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usertwo")
public class UserTwo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotBlank(message="Email is require")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message="Name is require")
	private String name;
	
	@NotBlank(message= "Password is require")
	@Size(min = 8, message= "Password must be at least 8 character")
	private String password;
	
	private String roll = "USER";
	
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	public UserTwo() {
	}

	public UserTwo(Long id, @Email @NotBlank(message = "Email is require") String email,
			@NotBlank(message = "Name is require") String name,
			@NotBlank(message = "Password is require") @Size(min = 8, message = "Password must be at least 8 character") String password,
			String roll, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.roll = roll;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
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

	public String getRoll() {
		return roll;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
		
}
