package com.suis.logistics.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

public abstract class BaseDao {

	@Autowired
	protected CacheManager	cacheManager;
	@Autowired
	SessionFactory	sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void clearCache(String cacheName) {
		cacheManager.getCache(cacheName).clear();
	}

}
