package com.suis.logistics.service.authentication;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Auth;
import com.suis.logistics.model.User;
import com.suis.logistics.service.user.UserService;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {
	@Resource
	UserService userService;

	@Override
	public Auth login(String username, String password) {
		Auth auth = null;
		User userDB = userService.getUserByUserName(username); 
		if(userDB != null && userDB.getUserName() != null  && userDB.getUserName().equals(username) && userDB.getStaus().equals("ACTIVE")) {
			if(userDB.getPassword().equals(password)) {
				auth = new Auth();
				
				//User Details
				auth.setUser(buildUserResponse(userDB));
				
				auth.setExpiresAt(120);
				
				auth.setAccessToken(username + System.currentTimeMillis());
				
			}
		}
		return auth;
	}

	private User buildUserResponse(User userDB) {
		User userResponse = new User();
		userResponse.setName(userDB.getName());
		userResponse.setUserName(userDB.getUserName());
		userResponse.setEmailId(userDB.getEmailId());
		userResponse.setStaus(userDB.getStaus());
		userResponse.setId(userDB.getId());
		userResponse.setRole(userDB.getRole());
		userResponse.setClient(userDB.getClient());
		return userResponse;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

}
