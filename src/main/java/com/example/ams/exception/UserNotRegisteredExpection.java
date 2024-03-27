package com.example.ams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class UserNotRegisteredExpection extends RuntimeException {
	private String message;
}
