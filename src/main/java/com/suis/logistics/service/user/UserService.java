package com.suis.logistics.service.user;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.User;
@Transactional
public interface UserService {
	
	public void createUser(User user);
	public User getUserByUserName(String userName);	
}
