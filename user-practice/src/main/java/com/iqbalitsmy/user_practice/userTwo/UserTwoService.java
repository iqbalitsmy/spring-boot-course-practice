package com.iqbalitsmy.user_practice.userTwo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserTwoService {
	private UserTwoRepository repository;

	public UserTwoService(UserTwoRepository repository) {
		this.repository = repository;
	}

	public UserTwoDTO createUser(UserCreateTwoRequest request) {
		
		if (repository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already exist: "+ request.getEmail());
		}
		
		UserTwo user = new UserTwo();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		
		UserTwo saved = repository.save(user);
		
		return toDTO(saved);
	}
	

	public List<UserTwoDTO> getAllUsers() {
		return  repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public void updateUser(Long id, UserUpdateTwoRequest request) {
		UserTwo user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id));
			
			if ( (request.getEmail() != null && !request.getEmail().trim().isEmpty()) && repository.existsByEmail(request.getEmail())) {
				throw new RuntimeException("Email already exist: "+ request.getEmail());
			}
			
			if(request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
				user.setEmail(request.getEmail());
			}
			if(request.getName() != null && !request.getName().trim().isEmpty()) {
				user.setName(request.getName());
			}
			if(request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
				user.setPassword(request.getPassword());
			}
			
			repository.save(user);
	}
	
	public UserTwoDTO getUser(Long id) {
		UserTwo user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id) );
		
		return toDTO(user);
	}
	
	private UserTwoDTO toDTO(UserTwo user) {
		UserTwoDTO userDTO = new UserTwoDTO(
				user.getId(),
				user.getEmail(), 
				user.getName(), 
				user.getRoll(),
				user.getCreatedAt()
				);
		
		return userDTO;
	}

	public void deleteUser(Long id) {
		repository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id) );
		
		repository.deleteById(id);
	}
	
}
