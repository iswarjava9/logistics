package com.suis.logistics.common;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.Auth;
import com.suis.logistics.model.BillOfLading;
import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.BusinessLine;
import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.CargoTemplate;
import com.suis.logistics.model.City;
import com.suis.logistics.model.Client;
import com.suis.logistics.model.Commodity;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.model.Customer;
import com.suis.logistics.model.Division;
import com.suis.logistics.model.IncoTerm;
import com.suis.logistics.model.MovementType;
import com.suis.logistics.model.Person;
import com.suis.logistics.model.PieceType;
import com.suis.logistics.model.Place;
import com.suis.logistics.model.Quotation;
import com.suis.logistics.model.TimeZone;
import com.suis.logistics.model.User;
import com.suis.logistics.model.Vessel;
import com.suis.logistics.web.CityDto;
import com.suis.logistics.web.TimeZoneDto;
import com.suis.logistics.web.authentication.AuthDto;
import com.suis.logistics.web.billoflading.BillOfLadingDto;
import com.suis.logistics.web.booking.BookingDto;
import com.suis.logistics.web.businessline.BusinessLineDto;
import com.suis.logistics.web.cargo.CargoDto;
import com.suis.logistics.web.cargotemplate.CargoTemplateDto;
import com.suis.logistics.web.client.ClientDto;
import com.suis.logistics.web.commodity.CommodityDto;
import com.suis.logistics.web.container.ContainerDto;
import com.suis.logistics.web.containertype.ContainerTypeDto;
import com.suis.logistics.web.customer.CustomerDto;
import com.suis.logistics.web.division.DivisionDto;
import com.suis.logistics.web.incoterm.IncoTermDto;
import com.suis.logistics.web.movementtype.MovementTypeDto;
import com.suis.logistics.web.person.PersonDto;
import com.suis.logistics.web.piecetype.PieceTypeDto;
import com.suis.logistics.web.place.PlaceDto;
import com.suis.logistics.web.quotation.QuotationDto;
import com.suis.logistics.web.user.UserDto;
import com.suis.logistics.web.vessel.VesselDto;

@Component
public class ConverterUtil {

	@Resource
	DateUtil			dateUtil;
	@Resource
	public ModelMapper	modelMapper;

	@PostConstruct
	public void init() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
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
		/*
		 * Person primaryContact = new Person();
		 * primaryContact.setId(customerDto.getContactId());
		 * customer.setPrimaryContact(primaryContact);
		 */
		return customer;
	}

	public Division convertDivisionDtoToEntity(DivisionDto divisionDto) {
		return modelMapper.map(divisionDto, Division.class);
	}

	public Place convertPlaceDtoToEntity(PlaceDto placeDto) {
		return modelMapper.map(placeDto, Place.class);
	}

	public BookingDetail convertBookingDtoToEntity(BookingDto bookingDto) {
		associateTimeZoneWithRespectToPlace(bookingDto);
		BookingDetail bookingDetail = modelMapper.map(bookingDto, BookingDetail.class);
		String remarks = bookingDetail.getRemarks();
		if (remarks != null) {
			bookingDetail.setRemarks(convertTextAreaToEntityDataCompatible(remarks));
		}
		return bookingDetail;
	}

	private String convertTextAreaToEntityDataCompatible(String textAreaData) {
		if (textAreaData != null) {
			return textAreaData.replace("\n", "\\n");
		}
		return null;
	}

	public String convertEntityDataToTextAreaCompatible(String entityData) {
		if (entityData != null) {
			return entityData.replace("\\n", "\n");
		}
		return null;
	}

	public BookingDto convertBookingDetailToDto(BookingDetail bookingDetail) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		BookingDto bookingDto = modelMapper.map(bookingDetail, BookingDto.class);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		// DateTime conversion to any required timezone
		// bookingDto.setDocsCutOffDateTime(dateUtil.convertDateToSpecificTimeZone(bookingDto.getDocsCutOffDateTime(),"US/Arizona"));
		return bookingDto;
	}

	public List<BookingDto> convertBookingDetailToDtoList(List<BookingDetail> bookingList) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Type listType = new TypeToken<List<BookingDto>>() {
		}.getType();
		List<BookingDto> bookingDtoList = modelMapper.map(bookingList, listType);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return bookingDtoList;
	}

	public Quotation convertQuotationDtoToEntity(QuotationDto quotationDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(quotationDto, Quotation.class);
	}

	public QuotationDto convertQuotationToDto(Quotation quotation) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(quotation, QuotationDto.class);
	}

	public List<QuotationDto> convertQuotationToDtoList(List<Quotation> quotations) {

		Type listType = new TypeToken<List<QuotationDto>>() {
		}.getType();
		List<QuotationDto> quotationDtoList = modelMapper.map(quotations, listType);
		return quotationDtoList;
	}

	public BusinessLine convertBusinessLineDtoToEntity(BusinessLineDto businessLineDto) {
		return modelMapper.map(businessLineDto, BusinessLine.class);
	}

	public BusinessLineDto convertBusinessLineToDto(BusinessLine businessLine) {
		return modelMapper.map(businessLine, BusinessLineDto.class);
	}

	public Commodity convertCommodityDtoToEntity(CommodityDto commodityDto) {
		return modelMapper.map(commodityDto, Commodity.class);
	}

	public CommodityDto convertCommodityToDto(Commodity commodity) {
		return modelMapper.map(commodity, CommodityDto.class);
	}

	public ContainerDetail convertContainerDtoToEntity(ContainerDto containerDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		ContainerDetail containerDetail = modelMapper.map(containerDto, ContainerDetail.class);
		BookingDetail bookingDetail = new BookingDetail();
		bookingDetail.setId(containerDto.getBookingDetailId());
		containerDetail.setBookingDetail(bookingDetail);
		return containerDetail;
	}

	public ContainerDto convertContainerToDto(ContainerDetail container) {
		return modelMapper.map(container, ContainerDto.class);
	}

	public ContainerType convertContainerTypeDtoToEntity(ContainerTypeDto containerTypeDto) {
		return modelMapper.map(containerTypeDto, ContainerType.class);
	}

	public ContainerTypeDto convertContainerTypeToDto(ContainerType containerType) {
		return modelMapper.map(containerType, ContainerTypeDto.class);
	}

	public void setLocalDateTimeToModelMapper() {
		Provider<LocalDateTime> localDateProvider = new AbstractProvider<LocalDateTime>() {
			@Override
			public LocalDateTime get() {
				return LocalDateTime.now();
			}
		};
		Converter<String, LocalDateTime> toStringDate = new AbstractConverter<String, LocalDateTime>() {
			@Override
			protected LocalDateTime convert(String source) {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime localDateTime = LocalDateTime.parse(source, format);
				return localDateTime;
			}
		};
		modelMapper.createTypeMap(String.class, LocalDateTime.class);
		modelMapper.addConverter(toStringDate);
		modelMapper.getTypeMap(String.class, LocalDateTime.class).setProvider(localDateProvider);
	}

	public IncoTerm convertIncoTermDtoToEntity(IncoTermDto incoTermDto) {
		return modelMapper.map(incoTermDto, IncoTerm.class);
	}

	public IncoTermDto convertIncoTermToDto(IncoTerm incoTerm) {
		return modelMapper.map(incoTerm, IncoTermDto.class);
	}

	public PieceType convertPieceTypeDtoToEntity(PieceTypeDto pieceTypeDto) {
		return modelMapper.map(pieceTypeDto, PieceType.class);
	}

	public PieceTypeDto convertPieceTypeToDto(PieceType pieceType) {
		return modelMapper.map(pieceType, PieceTypeDto.class);
	}

	public MovementType convertMovementTypeDtoToEntity(MovementTypeDto movementTypeDto) {
		return modelMapper.map(movementTypeDto, MovementType.class);
	}

	public MovementTypeDto convertMovementTypeToDto(MovementType movementType) {
		return modelMapper.map(movementType, MovementTypeDto.class);
	}

	public Vessel convertVesselDtoToEntity(VesselDto vesselDto) {
		return modelMapper.map(vesselDto, Vessel.class);
	}

	public VesselDto convertVesselToDto(Vessel vessel) {
		return modelMapper.map(vessel, VesselDto.class);
	}

	public Cargo convertCargoDtoToEntity(CargoDto cargoDto) {
		return modelMapper.map(cargoDto, Cargo.class);
	}

	public CargoDto convertCargoToDto(Cargo cargo) {
		return modelMapper.map(cargo, CargoDto.class);
	}

	public CargoTemplate convertCargoTemplateDtoToEntity(CargoTemplateDto cargoTemplateDto) {
		return modelMapper.map(cargoTemplateDto, CargoTemplate.class);
	}

	public CargoTemplateDto convertCargoTemplateToDto(CargoTemplate cargoTemplate) {
		return modelMapper.map(cargoTemplate, CargoTemplateDto.class);
	}

	public CustomerDto convertCustomerToDto(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);
	}

	public List<CustomerDto> convertCustomerListToDto(List<Customer> customers) {
		Type listType = new TypeToken<List<CustomerDto>>() {
		}.getType();
		List<CustomerDto> customerList = modelMapper.map(customers, listType);
		return customerList;
	}

	public PlaceDto convertPlaceToDto(Place place) {
		return modelMapper.map(place, PlaceDto.class);
	}

	public List<PlaceDto> convertPlaceListToDto(List<Place> places) {
		Type listType = new TypeToken<List<PlaceDto>>() {
		}.getType();
		List<PlaceDto> placeList = modelMapper.map(places, listType);
		return placeList;
	}

	public List<VesselDto> convertVesselListToDto(List<Vessel> vessels) {
		Type listType = new TypeToken<List<VesselDto>>() {
		}.getType();
		List<VesselDto> vesselList = modelMapper.map(vessels, listType);
		return vesselList;
	}

	public DivisionDto convertDivisionToDto(Division division) {
		return modelMapper.map(division, DivisionDto.class);
	}

	public List<DivisionDto> convertDivisionListToDto(List<Division> allDivisions) {
		Type listType = new TypeToken<List<DivisionDto>>() {
		}.getType();
		List<DivisionDto> divisionList = modelMapper.map(allDivisions, listType);
		return divisionList;
	}

	public UserDto convertUserToDto(User user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	public PersonDto convertPersonToDto(Person person) {
		return modelMapper.map(person, PersonDto.class);
	}

	public List<PersonDto> convertPersonListToDto(List<Person> persons) {
		Type listType = new TypeToken<List<PersonDto>>() {
		}.getType();
		List<PersonDto> personList = modelMapper.map(persons, listType);
		return personList;
	}

	public List<BusinessLineDto> convertBusinessLineListToDto(List<BusinessLine> businessLines) {
		Type listType = new TypeToken<List<BusinessLineDto>>() {
		}.getType();
		List<BusinessLineDto> businessLineList = modelMapper.map(businessLines, listType);
		return businessLineList;
	}

	public List<MovementTypeDto> convertMovementTypeListToDto(List<MovementType> movementTypes) {
		Type listType = new TypeToken<List<MovementTypeDto>>() {
		}.getType();
		List<MovementTypeDto> movementTypeList = modelMapper.map(movementTypes, listType);
		return movementTypeList;
	}

	public List<CityDto> convertCityListToDto(List<City> citiesByName) {
		Type listType = new TypeToken<List<CityDto>>() {
		}.getType();
		List<CityDto> cities = modelMapper.map(citiesByName, listType);
		return cities;
	}

	public List<ContainerTypeDto> convertContainerTypeListToDto(List<ContainerType> containerTypesByType) {
		Type listType = new TypeToken<List<ContainerTypeDto>>() {
		}.getType();
		List<ContainerTypeDto> containerTypes = modelMapper.map(containerTypesByType, listType);
		return containerTypes;
	}

	public List<CommodityDto> convertCommodityListToDto(List<Commodity> commoditiesByName) {
		Type listType = new TypeToken<List<CommodityDto>>() {
		}.getType();
		List<CommodityDto> commodities = modelMapper.map(commoditiesByName, listType);
		return commodities;
	}

	public AuthDto convertAuthToDto(Auth auth) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(auth, AuthDto.class);
	}

	public List<TimeZoneDto> convertListTimeZoneToDto(List<TimeZone> availableTimeZonesByCountry) {
		Type listType = new TypeToken<List<TimeZoneDto>>() {
		}.getType();
		List<TimeZoneDto> timeZones = modelMapper.map(availableTimeZonesByCountry, listType);
		return timeZones;
	}

	public void convertDateTimeFromUTCtoPlaceTimeZone(BookingDto bookingDto) {

		// as per port of load
		PlaceDto portOfLoad = bookingDto.getPortOfLoad();
		if (portOfLoad != null && portOfLoad.getCity() != null) {
			String timeZonePortOfLoad = portOfLoad.getCity().getTimeZone();
			if (timeZonePortOfLoad != null && !timeZonePortOfLoad.isEmpty()) {
				bookingDto.setPortCutOffDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getPortCutOffDate(), timeZonePortOfLoad));
				bookingDto.setDocsCutOffDateTime(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getDocsCutOffDateTime(), timeZonePortOfLoad));
				bookingDto.setSailDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getSailDate(), timeZonePortOfLoad));
				bookingDto.setDocsReceivedDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getDocsReceivedDate(), timeZonePortOfLoad));
			}
		}
		PlaceDto portOfDischarge = bookingDto.getPortOfDischarge();
		if (portOfDischarge != null && portOfDischarge.getCity() != null) {
			String tzPortOfDischarge = portOfDischarge.getCity().getTimeZone();
			if (tzPortOfDischarge != null && !tzPortOfDischarge.isEmpty()) {
				bookingDto.setEta(dateUtil.convertDateToSpecificTimeZone(bookingDto.getEta(), tzPortOfDischarge));
			}
		}
		PlaceDto emptyPickupDepot = bookingDto.getEmptyContainerPickup();
		if (emptyPickupDepot != null && emptyPickupDepot.getCity() != null) {
			String tzEmptyPickupDepot = emptyPickupDepot.getCity().getTimeZone();
			if (tzEmptyPickupDepot != null && !tzEmptyPickupDepot.isEmpty()) {
				bookingDto.setEmptyPickupDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getEmptyPickupDate(), tzEmptyPickupDepot));
			}
		}
		PlaceDto ingateTerminal = bookingDto.getIngateAtTerminal();
		if (ingateTerminal != null && ingateTerminal.getCity() != null) {
			String tzIngateTerminal = ingateTerminal.getCity().getTimeZone();
			if (tzIngateTerminal != null && !tzIngateTerminal.isEmpty()) {
				bookingDto.setEarlyReceivingDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getEarlyReceivingDate(), tzIngateTerminal));
			}
		}
		PlaceDto placeOfReceipt = bookingDto.getPlaceOfReceipt();
		if (placeOfReceipt != null && placeOfReceipt.getCity() != null) {
			String tzPlaceOfReceipt = placeOfReceipt.getCity().getTimeZone();
			if (tzPlaceOfReceipt != null && !tzPlaceOfReceipt.isEmpty()) {
				bookingDto.setCargoMovingDate(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getCargoMovingDate(), tzPlaceOfReceipt));
				bookingDto.setRailCutOffDateTime(
						dateUtil.convertDateToSpecificTimeZone(bookingDto.getRailCutOffDateTime(), tzPlaceOfReceipt));
			}
		}
	}

	public void associateTimeZoneWithRespectToPlace(BookingDto bookingDto) {

		PlaceDto portOfLoad = bookingDto.getPortOfLoad();
		if (portOfLoad != null && portOfLoad.getCity() != null) {
			String timeZonePortOfLoad = portOfLoad.getCity().getTimeZone();
			if (timeZonePortOfLoad != null && !timeZonePortOfLoad.isEmpty()) {

				LocalDateTime portCutDate = bookingDto.getPortCutOffDate();
				bookingDto.setPortCutOffDate(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(portCutDate, timeZonePortOfLoad));
				//
				LocalDateTime docsCutDate = bookingDto.getDocsCutOffDateTime();
				bookingDto.setDocsCutOffDateTime(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(docsCutDate, timeZonePortOfLoad));
				//
				LocalDateTime sailDate = bookingDto.getSailDate();
				bookingDto.setSailDate(
						dateUtil.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(sailDate, timeZonePortOfLoad));
				//
				LocalDateTime docsreceivedate = bookingDto.getDocsReceivedDate();
				bookingDto.setDocsReceivedDate(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(docsreceivedate, timeZonePortOfLoad));
			}
		}
		PlaceDto portOfDischarge = bookingDto.getPortOfDischarge();
		if (portOfDischarge != null && portOfDischarge.getCity() != null) {
			String tzPortOfDischarge = portOfDischarge.getCity().getTimeZone();
			if (tzPortOfDischarge != null && !tzPortOfDischarge.isEmpty()) {
				LocalDateTime eta = bookingDto.getEta();
				bookingDto.setEta(
						dateUtil.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(eta, tzPortOfDischarge));
			}
		}
		PlaceDto emptyPickupDepot = bookingDto.getEmptyContainerPickup();
		if (emptyPickupDepot != null && emptyPickupDepot.getCity() != null) {
			String tzEmptyPickupDepot = emptyPickupDepot.getCity().getTimeZone();
			if (tzEmptyPickupDepot != null && !tzEmptyPickupDepot.isEmpty()) {
				LocalDateTime emptyPickupDate = bookingDto.getEmptyPickupDate();
				bookingDto.setEmptyPickupDate(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(emptyPickupDate, tzEmptyPickupDepot));
			}
		}
		PlaceDto ingateTerminal = bookingDto.getIngateAtTerminal();
		if (ingateTerminal != null && ingateTerminal.getCity() != null) {
			String tzIngateTerminal = ingateTerminal.getCity().getTimeZone();
			if (tzIngateTerminal != null && !tzIngateTerminal.isEmpty()) {
				LocalDateTime earlyReceivingDate = bookingDto.getEarlyReceivingDate();
				bookingDto.setEarlyReceivingDate(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(earlyReceivingDate, tzIngateTerminal));
			}
		}
		PlaceDto placeOfReceipt = bookingDto.getPlaceOfReceipt();
		if (placeOfReceipt != null && placeOfReceipt.getCity() != null) {
			String tzPlaceOfReceipt = placeOfReceipt.getCity().getTimeZone();
			if (tzPlaceOfReceipt != null && !tzPlaceOfReceipt.isEmpty()) {
				LocalDateTime cargoMovingDate = bookingDto.getCargoMovingDate();
				bookingDto.setCargoMovingDate(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(cargoMovingDate, tzPlaceOfReceipt));
				//
				LocalDateTime railCutDate = bookingDto.getRailCutOffDateTime();
				bookingDto.setRailCutOffDateTime(dateUtil
						.convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(railCutDate, tzPlaceOfReceipt));
			}
		}
	}

	public BillOfLadingDto convertBillOfLadingToDto(BillOfLading billOfLading) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		BillOfLadingDto billOfLadingDto = modelMapper.map(billOfLading, BillOfLadingDto.class);
		billOfLadingDto
				.setCargoDescription(convertEntityDataToTextAreaCompatible(billOfLadingDto.getCargoDescription()));
		billOfLadingDto.setShipper(convertEntityDataToTextAreaCompatible(billOfLadingDto.getShipper()));
		billOfLadingDto.setConsignee(convertEntityDataToTextAreaCompatible(billOfLadingDto.getConsignee()));
		billOfLadingDto.setPortOfDischarge(convertEntityDataToTextAreaCompatible(billOfLadingDto.getPortOfDischarge()));
		billOfLadingDto.setPortOfLoad(convertEntityDataToTextAreaCompatible(billOfLadingDto.getPortOfLoad()));
		billOfLadingDto.setNotify(convertEntityDataToTextAreaCompatible(billOfLadingDto.getNotify()));
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return billOfLadingDto;
	}

	public BillOfLading convertBillOfLadingDtoToEntity(BillOfLadingDto billOfLadingDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		BillOfLading billOfLading = modelMapper.map(billOfLadingDto, BillOfLading.class);

		billOfLading.setCargoDescription(convertTextAreaToEntityDataCompatible(billOfLading.getCargoDescription()));
		billOfLading.setShipper(convertTextAreaToEntityDataCompatible(billOfLading.getShipper()));
		billOfLading.setConsignee(convertTextAreaToEntityDataCompatible(billOfLading.getConsignee()));
		billOfLading.setPortOfDischarge(convertTextAreaToEntityDataCompatible(billOfLading.getPortOfDischarge()));
		billOfLading.setPortOfLoad(convertTextAreaToEntityDataCompatible(billOfLading.getPortOfLoad()));
		billOfLading.setNotify(convertTextAreaToEntityDataCompatible(billOfLading.getNotify()));
		return billOfLading;
	}
}
