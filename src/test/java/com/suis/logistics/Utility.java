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
import com.suis.logistics.web.CountryDto;
import com.suis.logistics.web.StateDto;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.incoterm.IncoTermDto;
import com.suis.logistics.web.movementtype.MovementTypeDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.quotation.QuotationDto;
import com.suis.logistics.web.vessel.VesselDto;

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
		QuotationDto obj = new QuotationDto();

		obj.setAgentDriven(true);
		obj.setBusinessLine(new BusinessLineDto());
		obj.setContainerDetail(new ContainerDto());
		obj.setCountry(new CountryDto());
		obj.setCustomer(new CustomerDto());
		obj.setDivision(new DivisionDto());
		obj.setFinalDestination(new PlaceDto());
		obj.setIncoTerm(new IncoTermDto());
		obj.setMovementType(new MovementTypeDto());
		obj.setPickupCity(new PlaceDto());
		obj.setPortOfDischarge(new PlaceDto());
		obj.setPortOfLoad(new PlaceDto());
		obj.setPreferredCarrier(new PlaceDto());
		obj.setPrimaryContact(new PersonDto());
		obj.setSalesRepresentative(new PersonDto());
		obj.setState(new StateDto());
		obj.setVessel(new VesselDto());


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
