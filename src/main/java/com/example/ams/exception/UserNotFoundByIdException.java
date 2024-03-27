package com.example.ams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class UserNotFoundByIdException  extends RuntimeException{

	private String message;
}
