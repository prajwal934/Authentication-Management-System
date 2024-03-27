package com.example.ams.dto;

import java.time.LocalDateTime;

import com.example.ams.enums.ProfileVisibility;
import com.example.ams.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

	private int userId;
	private String userName;
	private String email;
	private String ph;
	private UserRole userRole;
	private ProfileVisibility profileVisibility;
	
	private LocalDateTime createdAt;
	private LocalDateTime lastModifiedAt;
}
