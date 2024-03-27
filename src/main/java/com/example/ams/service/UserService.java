package com.example.ams.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ams.dto.UserResponse;
import com.example.ams.model.User;
import com.example.ams.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponse>> registerUser(String userRole);
	
	ResponseEntity<ResponseStructure<UserResponse>> updateUserProfileVisibility(int userId, boolean profilePublic);

	ResponseEntity<ResponseStructure<List<User>>> getAllUsers();
}
