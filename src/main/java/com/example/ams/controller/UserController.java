package com.example.ams.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ams.dto.UserResponse;
import com.example.ams.model.User;
import com.example.ams.security.AllowRoleAdmin;
import com.example.ams.service.UserService;
import com.example.ams.utility.ResponseStructure;


@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping(value = "/roles/{userRole}/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@PathVariable String userRole) {
		return userService.registerUser(userRole);
	}
	
	@GetMapping("/test")
	public Object test() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@PutMapping(value = "/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUserProfileVisibility(@PathVariable int userId , @RequestParam boolean profilePublic ) {
		return userService.updateUserProfileVisibility(userId, profilePublic);
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers(){
		return userService.getAllUsers();
	}
}
