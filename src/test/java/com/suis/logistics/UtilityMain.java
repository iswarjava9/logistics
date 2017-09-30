package com.suis.logistics;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.Client;
import com.suis.logistics.web.CityDto;
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.movementtype.MovementTypeDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.vessel.VesselDto;

public class UtilityMain {

	public static void main(String[] args) throws Exception {

		// generateBookingToJsonString();
		// generateDivisonDtoToJsonString();
		// convertDtoToEntity();
		// date();
		// stringManipulation();
		// generateUniqueAlphaNumeric();
		// generateCustomerDtoToJsonString();
		// generatePlaceDtoToJsonString();
		//printAllTimeZones();
		//geoNamesAPI();
	}

	public static void printAllTimeZones() {
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		for (String zoneId : zoneIds) {
			ZoneId zone = ZoneId.of(zoneId);
			ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
			ZoneOffset offset = zonedDateTime.getOffset();
			String longName = zone.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			String shortDisplayName = TimeZone.getTimeZone(offset).getDisplayName(false, TimeZone.SHORT);
			System.out.println("(" + offset + ") " + zoneId + ", " + longName + "  " + shortDisplayName);
		}
	}

	public static void stringManipulation() {
		StringBuilder st = new StringBuilder("hello1234");
		int length = 6;
		String k = null;
		if (st.length() > length) {
			k = st.substring(st.length() - length, st.length());
		}
		System.out.println(k);
	}

	public static void workingOnDate() {
		// Asia/Kuala_Lumpur +8
		ZoneId defaultZoneId = ZoneId.systemDefault();
		System.out.println("System Default TimeZone : " + defaultZoneId);
		// toString() append +8 automatically.
		Date date = new Date();
		System.out.println("date : " + date);
		// 1. Convert Date -> Instant
		Instant instant = date.toInstant();
		System.out.println("instant : " + instant); // Zone : UTC+0
		// 2. Instant + system default time zone + toLocalDate() = LocalDate
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		System.out.println("localDate : " + localDate);
		// 3. Instant + system default time zone + toLocalDateTime() =
		// LocalDateTime
		LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
		System.out.println("localDateTime : " + localDateTime);
		// 4. Instant + system default time zone = ZonedDateTime
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
		System.out.println("zonedDateTime : " + zonedDateTime);
		System.out.println(Date.from(zonedDateTime.toInstant()));
	}

	public static void date() {
		System.out.println(ZoneId.getAvailableZoneIds());
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		System.out.println(ZoneId.systemDefault());
		ZonedDateTime current = now.atZone(ZoneId.systemDefault());
		System.out.println(current);
		ZonedDateTime zdt = current.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println(zdt.toLocalDateTime());
	}

	public static void generateBookingToJsonString() {

		// Client obj = new Client();
		BookingDto obj = new BookingDto();
		obj.setContainerDetails(Arrays.asList(new ContainerDto(), new ContainerDto()));
		obj.setClient(new ClientDto());
		obj.setBillTo(new CustomerDto());
		obj.setAesAuthNo("aes-auth-002");
		obj.setConsignee(new CustomerDto());
		obj.setDeliveryAgent(new CustomerDto());
		obj.setEmptyContainerPickup(new PlaceDto());
		obj.setTranshipmentPort(new PlaceDto());
		obj.setShipper(new CustomerDto());
		obj.setPortOfLoad(new PlaceDto());
		obj.setPortOfDischarge(new PlaceDto());
		obj.setPlaceOfReceipt(new PlaceDto());
		obj.setPlaceOfDelivery(new PlaceDto());
		obj.setNotify1(new CustomerDto());
		obj.setNotify2(new CustomerDto());
		obj.setLocalSSLineOffice(new CustomerDto());
		obj.setForwarder(new CustomerDto());
		obj.setLineOfBusiness(new BusinessLineDto());
		obj.setSalesRepresentative(new PersonDto());
		obj.setVessel(new VesselDto());
		obj.setDivision(new DivisionDto());
		obj.setTypeOfMove(new MovementTypeDto());
		obj.setBookingPerson(new PersonDto());
		obj.setCarrier(new CustomerDto());
		// Object to JSON in String
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.findAndRegisterModules();
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateDivisonDtoToJsonString() {
		DivisionDto div = new DivisionDto();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.findAndRegisterModules();
			String jsonInString = mapper.writeValueAsString(div);
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateCustomerDtoToJsonString() throws Exception {

		CustomerDto cus = new CustomerDto();
		cus.setCity(new CityDto());
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cus);
		System.out.println(jsonInString);
	}

	public static void generatePlaceDtoToJsonString() throws Exception {

		PlaceDto cus = new PlaceDto();
		cus.setCity(new CityDto());
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cus);
		System.out.println(jsonInString);
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

	public static void generateUniqueAlphaNumeric() {
		String k = RandomStringUtils.random(8, false, true);
		System.out.println(k);
	}

	/*public static void geoNamesAPI() throws Exception{
		WebService.setUserName("demo"); // add your username here
Timezone tz = WebService.timezone(42.773333, 21.286111);
System.out.println(tz.getTimezoneId());
		  ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		  searchCriteria.setQ("new Jersey");

		  ToponymSearchResult searchResult = WebService.search(searchCriteria);
		  for (Toponym toponym : searchResult.getToponyms()) {
		     System.out.println(toponym.getName()+" "+ toponym.getCountryName()+ "");
		  }
	}*/
}
