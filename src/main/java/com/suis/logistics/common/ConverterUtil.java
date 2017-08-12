package com.suis.logistics.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.BusinessLine;
import com.suis.logistics.model.Client;
import com.suis.logistics.model.Customer;
import com.suis.logistics.model.Division;
import com.suis.logistics.model.Person;
import com.suis.logistics.model.Place;
import com.suis.logistics.model.Quotation;
import com.suis.logistics.model.User;
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.quotation.QuotationDto;
import com.suis.logistics.web.user.UserDto;

@Component
public class ConverterUtil {

	@Resource
	DateUtil			dateUtil;
	@Resource
	public ModelMapper	modelMapper;

	@PostConstruct
	public void init() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	}

	public Client convertClientDtoToEntity(ClientDto clientDto) {
		return modelMapper.map(clientDto, Client.class);
	}

	public User convertUserDtoToEntity(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}

	public Person convertPersonDtoToEntity(PersonDto personDto) {
		return modelMapper.map(personDto, Person.class);
	}

	public Customer convertCustomerDtoToEntity(CustomerDto customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Person primaryContact = new Person();
		primaryContact.setId(customerDto.getContactId());
		customer.setPrimaryContact(primaryContact);
		return customer;
	}

	public Division convertDivisionDtoToEntity(DivisionDto divisionDto) {
		return modelMapper.map(divisionDto, Division.class);
	}

	public Place convertPlaceDtoToEntity(PlaceDto placeDto) {
		return modelMapper.map(placeDto, Place.class);
	}

	public BookingDetail convertBookingDtoToEntity(BookingDto bookingDto) {
		BookingDetail bookingDetail = modelMapper.map(bookingDto, BookingDetail.class);
		return bookingDetail;
	}

	public BookingDto convertBookingDetailToDto(BookingDetail bookingDetail) {
		BookingDto bookingDto = modelMapper.map(bookingDetail, BookingDto.class);
		// DateTime conversion to any required timezone
		// bookingDto.setDocsCutOffDateTime(dateUtil.convertDateToSpecificTimeZone(bookingDto.getDocsCutOffDateTime(),"US/Arizona"));
		return bookingDto;
	}

	public Quotation convertQuotationDtoToEntity(QuotationDto quotationDto) {
		return modelMapper.map(quotationDto, Quotation.class);
	}

	public QuotationDto convertQuotationToDto(Quotation quotation) {
		return modelMapper.map(quotation, QuotationDto.class);
	}

	public BusinessLine convertBusinessLineDtoToEntity(BusinessLineDto businessLineDto) {
		return modelMapper.map(businessLineDto, BusinessLine.class);
	}

	public BusinessLineDto convertBusinessLineToDto(BusinessLine businessLine) {
		return modelMapper.map(businessLine, BusinessLineDto.class);
	}


}
