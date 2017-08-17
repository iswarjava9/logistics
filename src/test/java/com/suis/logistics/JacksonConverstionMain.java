package com.suis.logistics;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonConverstionMain {

	public static void main(String[] s) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.findAndRegisterModules();
		DateDto d1 = new DateDto(1, LocalDateTime.now());
		DateDto d2 = new DateDto(2, null);
		List<DateDto> dtolist = Arrays.asList(d1,d2);
		DateDtoList dlist = new DateDtoList(dtolist);
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dlist));
	}
}
