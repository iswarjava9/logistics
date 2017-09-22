package com.suis.logistics.service.authentication;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Auth;

@Transactional(propagation=Propagation.REQUIRED)
public interface AuthenticationService {
	public Auth login(String username, String password);
	public void logout();
	public boolean isAuthenticated();
}



