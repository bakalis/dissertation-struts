package com.bakalis.struts.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationService {
	public static Authentication auth;
	
	//Returns the Authentication Object
	public static Authentication getAuth(){
		auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
	
	
}
