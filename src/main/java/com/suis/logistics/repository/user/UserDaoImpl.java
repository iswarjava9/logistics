package com.suis.logistics.repository.user;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.User;
import com.suis.logistics.repository.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public Integer createUser(User user) {
		getCurrentSession().save(user);
		return user.getId();
		
	}
	
}
