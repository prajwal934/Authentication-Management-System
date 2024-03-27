package com.example.ams.security;

import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

import com.example.ams.exception.UserNotRegisteredExpection;
import com.example.ams.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@Aspect
@AllArgsConstructor
public class SecurityAspects {
	
	private UserRepository userRepo;
	
	@Before("@annotation(AllowRoleAdmin)")
	public void validateUserRole(JoinPoint joinPoint) {
		if(SecurityContextHolder.getContext().getAuthentication() == null)
			throw new RuntimeException("not authenticated");
	
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		boolean isValidAuthority = false;
		for(GrantedAuthority role : authorities) {
			if(role.getAuthority() == "ADMIN") isValidAuthority = true;
		}
		
		if(!isValidAuthority) throw new RuntimeException("not authorized");
	}
	
//	@Before("@annotation(AllowRoleUser)")
//	public void validateAdminRole(JoinPoint joinPoint) {
//		if(SecurityContextHolder.getContext().getAuthentication() == null)
//			throw new RuntimeException("Not Authenticated User");
//		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//		boolean isValidAuthority = false;
//		for(GrantedAuthority role : authorities) {
//			if(role.getAuthority() == "USER") isValidAuthority = true;
//		}
//		
//		if(!isValidAuthority) throw new RuntimeException("Not Authorized");
//		
//	}
//	
	@Before("execution(* com.example.ams.controller.*.*(..))")
	public void checkIfUserRegistered() {
		OidcUser user = (OidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(! userRepo.existsByEmail(user.getEmail())) throw new UserNotRegisteredExpection("Failed access");
	}
}
