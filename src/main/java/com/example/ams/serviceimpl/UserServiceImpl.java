package com.example.ams.serviceimpl;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.ams.dto.UserResponse;
import com.example.ams.enums.ProfileVisibility;
import com.example.ams.enums.UserRole;
import com.example.ams.exception.UserNotFoundByIdException;
import com.example.ams.model.User;
import com.example.ams.repository.UserRepository;
import com.example.ams.service.UserService;
import com.example.ams.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService{
	
	private UserRepository userRepository;
	private ResponseStructure<UserResponse> responseStructure;
	private ResponseStructure<List<User>> listResponseStructure;
	
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(String userRole) {
		OidcUser oidcUser = (OidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = User.builder()
				.userName(oidcUser.getName())
				.email(oidcUser.getEmail())
				.ph(oidcUser.getPhoneNumber())
				.profileVisibility(ProfileVisibility.PUBLIC)
				.build();
		switch (UserRole.valueOf(userRole.toUpperCase())) {
		case ADMIN -> user.setUserRole(UserRole.ADMIN);
		case USER -> user.setUserRole(UserRole.USER);
		}
		
		user = userRepository.save(user);
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("user registered successfully")
				.setData(mapToUserResponse(user)));
	}
	
	public UserResponse mapToUserResponse(User user) {
		return UserResponse.builder().userId(user.getUserId()).userName(user.getUserName()).email(user.getEmail())
				.ph(user.getPh())
				.profileVisibility(user.getProfileVisibility())
				.userRole(user.getUserRole())
				.lastModifiedAt(user.getLastModifiedAt())
				.createdAt(user.getCreatedAt())
				.build();
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> updateUserProfileVisibility(int userId,
			boolean isPrivate) {
		return userRepository.findById(userId).map(user -> {
			if(isPrivate) user.setProfileVisibility(ProfileVisibility.PRIVATE);
			else user.setProfileVisibility(ProfileVisibility.PUBLIC);
			user = userRepository.save(user);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage("Profile visibility updated")
					.setData(mapToUserResponse(user)));
		}).orElseThrow( () -> new UserNotFoundByIdException("User Not Updated"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
		OidcUser oidcUser= (OidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByEmail(oidcUser.getEmail()).map(user -> {
			List<User> users = null;
			if(user.getUserRole() == UserRole.ADMIN) {
				users = userRepository.findAll();
			}
			else {
				users = userRepository.findByProfileVisibility(ProfileVisibility.PUBLIC);
			}
			return ResponseEntity.status(HttpStatus.FOUND).body(listResponseStructure
					.setData(users)
					.setMessage("")
					.setStatuscode(HttpStatus.FOUND.value()));
		}).orElseThrow();
	}

	

}
