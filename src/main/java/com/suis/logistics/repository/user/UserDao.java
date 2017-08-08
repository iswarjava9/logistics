package com.suis.logistics.repository.user;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.User;
@Transactional
public interface UserDao {
	
	public Integer createUser(User user);
}
