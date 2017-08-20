package com.suis.logistics.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UniqueKeyGenerator {

	@Value("${unique.no.length}")
	private Integer length;

	public String generateUniqueKey(String prefix,int lastPrimaryKey){
		String randomNumber = RandomStringUtils.random(length, false, true);
		StringBuilder tempKey = new StringBuilder(prefix);
		tempKey.append("-").append(randomNumber).append(String.valueOf(lastPrimaryKey));
		return tempKey.toString();
	}
}
