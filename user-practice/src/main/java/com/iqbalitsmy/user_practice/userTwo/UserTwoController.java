package com.iqbalitsmy.user_practice.userTwo;

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


import jakarta.validation.Valid;

@RestController
@RequestMapping("/v2/api/users")
public class UserTwoController {
	private UserTwoService userService;

	public UserTwoController(UserTwoService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserTwoDTO> createUser(@Valid @RequestBody UserCreateTwoRequest request) {
		UserTwoDTO created = userService.createUser(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@GetMapping
	public ResponseEntity<List<UserTwoDTO>> getAllUsers() {
		List<UserTwoDTO> users = userService.getAllUsers();
		
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateTwoRequest request){
		userService.updateUser(id, request);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserTwoDTO> getUser(@PathVariable Long id){
		UserTwoDTO user = userService.getUser(id);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		
		return ResponseEntity.noContent().build();
	}
}
