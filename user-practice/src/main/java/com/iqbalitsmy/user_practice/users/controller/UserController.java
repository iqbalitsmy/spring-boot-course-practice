package com.iqbalitsmy.user_practice.users.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqbalitsmy.user_practice.user.service.UserService;
import com.iqbalitsmy.user_practice.users.dto.CreateUserRequest;
import com.iqbalitsmy.user_practice.users.dto.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserRequest request){
		UserDTO created = userService.createUser(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	@GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO>  users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
	
	// Get a user
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
		UserDTO user = userService.findById(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Void> udateUser(@PathVariable Long id, @Valid @RequestBody CreateUserRequest request ){
		userService.updateUser(id, request);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		userService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
