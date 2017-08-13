package com.suis.logistics.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.BusinessLine;
import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.CargoTemplate;
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
import com.suis.logistics.model.User;
import com.suis.logistics.model.Vessel;
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

	public Commodity convertCommodityDtoToEntity(CommodityDto commodityDto) {
		return modelMapper.map(commodityDto, Commodity.class);
	}

	public CommodityDto convertCommodityToDto(Commodity commodity) {
		return modelMapper.map(commodity, CommodityDto.class);
	}

	public ContainerDetail convertContainerDtoToEntity(ContainerDto containerDto) {

		return modelMapper.map(containerDto, ContainerDetail.class);
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
}
