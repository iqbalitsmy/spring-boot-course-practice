package com.iqbalitsmy.user_practice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iqbalitsmy.user_practice.users.exception.UserNotFoundException;
import com.iqbalitsmy.user_practice.users.repository.UserRepository;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
	@Autowired
	private UserRepository user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		return user.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found: "+username));
	}
}
