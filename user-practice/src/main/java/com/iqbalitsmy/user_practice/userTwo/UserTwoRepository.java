package com.iqbalitsmy.user_practice.userTwo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserTwoRepository extends JpaRepository<UserTwo, Long> {
	Optional<UserTwo> findByEmail(String email);
	
	boolean existsByEmail(String email);
}
