package com.iqbalitsmy.user_practice.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqbalitsmy.user_practice.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	
	boolean existsByEmail(String email);
}
