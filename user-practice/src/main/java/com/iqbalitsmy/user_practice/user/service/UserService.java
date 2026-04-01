package com.iqbalitsmy.user_practice.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iqbalitsmy.user_practice.users.dto.CreateUserRequest;
import com.iqbalitsmy.user_practice.users.dto.UserDTO;
import com.iqbalitsmy.user_practice.users.entity.User;
import com.iqbalitsmy.user_practice.users.exception.EmailAlreadyExistsException;
import com.iqbalitsmy.user_practice.users.exception.UserNotFoundException;
import com.iqbalitsmy.user_practice.users.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserDTO createUser(CreateUserRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyExistsException("Email already exist: "+ request.getEmail());
		}
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRoll("USER");
		
		User saved = userRepository.save(user);	
		
		return toDTO(saved);
	}
	
	public List<UserDTO> getAllUsers(){
		return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public UserDTO findById(Long id) {
		Optional<User> found = userRepository.findById(id);
		if (found.isEmpty()) {
			throw new UserNotFoundException("User not found: "+id);
		}
		
		return toDTO(found.get());
	}
	
	public UserDTO updateUser(Long id, CreateUserRequest request) {
		Optional<User> found = userRepository.findById(id);
		
		if (found.isEmpty()) {
			 throw new UserNotFoundException("User not found"+ id);
		}
		
		User user = found.get();
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		
		return toDTO(userRepository.save(user));
	}
	
	public void deleteById(Long id) {
			Optional<User> found = userRepository.findById(id);
			
			if (found.isEmpty()) {
				throw new UserNotFoundException("User not found: "+id);
			}
			
			userRepository.deleteById(id);
		}
	
	private UserDTO toDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getUsername(),
				user.getEmail(),
				user.getRoll(),
				user.getCreatedAt()
				);
	}

	
}
