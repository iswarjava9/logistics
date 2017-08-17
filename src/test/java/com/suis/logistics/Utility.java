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
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.customer.AccountShortInfo;
import com.suis.logistics.web.customer.ConsigneeShortInfo;
import com.suis.logistics.web.place.LoadTerminalShortInfo;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateObjectToJsonString();
		// convertDtoToEntity();

		//date();

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
System.out.println(ZoneId.getAvailableZoneIds());
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		System.out.println(ZoneId.systemDefault());
		ZonedDateTime current = now.atZone(ZoneId.systemDefault());
		System.out.println(current);
		ZonedDateTime zdt = current.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println(zdt.toLocalDateTime());






	}

	public static void generateObjectToJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		// Client obj = new Client();
		BookingDto obj = new BookingDto();
		obj.setAccountShortInfo(new AccountShortInfo());
		obj.setConsigneeShortInfo(new ConsigneeShortInfo());
		obj.setLoadTerminalShortInfo(new LoadTerminalShortInfo());
		//obj.setContainerDetail(new ContainerDto());

/*LocalDateTime curDate =  LocalDateTime.now();
		obj.setCargoTemplate(new CargoTemplateDto());

obj.setPieceType(new PieceTypeDto());
obj.setContainerId(1);*/



		// Object to JSON in String
		try {
			mapper.findAndRegisterModules();
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
