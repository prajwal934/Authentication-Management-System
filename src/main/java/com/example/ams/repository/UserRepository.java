package com.example.ams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ams.enums.ProfileVisibility;
import com.example.ams.enums.UserRole;
import com.example.ams.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);
	
	 Optional<User>  findByEmail(String email);

	 Optional<User> findByUserRole(UserRole userRole);

	List<User> findByProfileVisibility(ProfileVisibility visiblity);
		 

}
