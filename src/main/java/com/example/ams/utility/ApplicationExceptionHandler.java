package com.example.ams.utility;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.ams.exception.UserAlreadyExistByEmailException;
import com.example.ams.exception.UserNotRegisteredExpection;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	private ErrorStructure errorStructure;

	private ResponseEntity<ErrorStructure> errorResponse(HttpStatus status, String errorMessage,
			Object rootCause) {
		return new ResponseEntity<ErrorStructure>(
				errorStructure.setStatuscode(status.value()).setErrorMessage(errorMessage).setRootCause(rootCause),
				status);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotRegistered(UserNotRegisteredExpection ex){
		return errorResponse(HttpStatus.FORBIDDEN, ex.getMessage()+ "Please register for preffered roles", 
				Map.of(
						"USER", "/api/v1/roles/user/users/register",
						"ADMIN", "/api/v1/roles/admin/users/register"
						));
	}

	public ResponseEntity<ErrorStructure> handelUserAlreadyExistByEmail(UserAlreadyExistByEmailException ex) {
		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "User Already Exist with the given email id");
	}
}
