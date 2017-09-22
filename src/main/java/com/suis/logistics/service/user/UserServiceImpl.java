package com.suis.logistics.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Client;
import com.suis.logistics.model.User;
import com.suis.logistics.repository.client.ClientDao;
import com.suis.logistics.repository.user.UserDao;

@Component("userService")
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;
	
	@Resource
	ClientDao clientDao;
	
	@Override
	public void createUser(User user) {
		/*Client client = clientDao.findById(user.getClient().getId());
		user.setClient(client);*/
		userDao.createUser(user);
		
	}
	
	@Override
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	
}
