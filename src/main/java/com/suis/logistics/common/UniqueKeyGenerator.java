package com.suis.logistics.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UniqueKeyGenerator {

	@Value("${unique.no.length}")
	private Integer length;

	public String generateUniqueKey(String prefix, int lastPrimaryKey) {

		String lastPrimaryKeyText = String.valueOf(lastPrimaryKey);
		int randomKeyLength = length - lastPrimaryKeyText.length();
		String randomNumber = RandomStringUtils.random(randomKeyLength, false, true);
		StringBuilder finalUniqueKey = new StringBuilder(prefix);
		finalUniqueKey.append("-").append(randomNumber).append(lastPrimaryKeyText);
		return finalUniqueKey.toString();
	}

}
