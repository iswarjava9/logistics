package com.suis.logistics.web.authentication;

import com.suis.logistics.model.User;

public class AuthDto {
	private String accessToken;
	private int expiresAt;
	private User user;

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(int expiresAt) {
		this.expiresAt = expiresAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
