package com.example.ams.dto;

import com.example.ams.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

	@NotNull
	private String userName;
	@Email(regexp = ".+@.+\\..+" ,  message = "Please provide a valid email")
	private String email;
	@Max(value = 9999999999l)
	@Min(value = 6000000000l)
	private Long ph;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must"
			+ " contain at least one letter, one number, one special character")
	private String password;
	private UserRole userRole;
	
	
}
