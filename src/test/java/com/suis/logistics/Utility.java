package com.suis.logistics;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.Client;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.place.PlaceDto;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//generateObjectToJsonString();
		// convertDtoToEntity();

		date();

	}

	public static void workingOnDate(){
		//Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);

        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);

        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        System.out.println("zonedDateTime : " + zonedDateTime);
        System.out.println(Date.from(zonedDateTime.toInstant()));
	}

	public static void date(){
		Date today = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(), ZoneId.of("UTC"));
		System.out.println(ldt);
		ZonedDateTime zdt = ldt.atZone(ZoneId.of("UTC"));

		Date output = Date.from(zdt.toInstant());

		System.out.println(zdt);
		System.out.println(output);

		Instant inst = zdt.toInstant();

		Date newDate = Date.from(inst);

		System.out.println(inst);








	}

	public static void generateObjectToJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		// Client obj = new Client();
		PlaceDto obj = new PlaceDto();

		// Object to JSON in String
		try {
			String jsonInString = mapper.writeValueAsString(obj);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void convertDtoToEntity() {
		ModelMapper modelMapper = new ModelMapper();
		ClientDto clientDto = new ClientDto();
		clientDto.setAddress("address");
		clientDto.setId(787);
		Client client = modelMapper.map(clientDto, Client.class);

		System.out.println(client);
	}

	public static void convertEntityToDto() {
		ModelMapper modelMapper = new ModelMapper();
		ClientDto clientDto = new ClientDto();
		clientDto.setAddress("address");
		clientDto.setId(787);
		Client client = modelMapper.map(clientDto, Client.class);

		System.out.println(client);
	}
}
