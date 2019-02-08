package com.bakalis.struts.actions;

import org.springframework.security.core.Authentication;

import com.bakalis.struts.services.AuthenticationService;

public class LoginAction {

	protected Authentication auth;
	
	public Authentication getAuth() {
		return auth;
	}



	public void setAuth(Authentication auth) {
		this.auth = auth;
	}


	//Just get the Authentication Object then return the View
	public String execute(){
		auth = AuthenticationService.getAuth();
		return "login";
	}
}
