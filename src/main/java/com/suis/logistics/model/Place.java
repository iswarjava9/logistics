package com.suis.logistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the physical_entity database table.
 *
 */
@Entity
@Table(name="place")
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="brokerage_rate")
	private int brokerageRate;

	private String code;

	@Column(name="country_code")
	private String countryCode;

	private String name;

	@Column(name="port_state_code")
	private String portStateCode;

	@Column(name="type_id")
	private int typeId;

	@Column(name="un_code")
	private String unCode;


	public Place() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrokerageRate() {
		return this.brokerageRate;
	}

	public void setBrokerageRate(int brokerageRate) {
		this.brokerageRate = brokerageRate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortStateCode() {
		return this.portStateCode;
	}

	public void setPortStateCode(String portStateCode) {
		this.portStateCode = portStateCode;
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getUnCode() {
		return this.unCode;
	}

	public void setUnCode(String unCode) {
		this.unCode = unCode;
	}

	/*public List<BookingDetail> getBookingDetails1() {
		return this.bookingDetails1;
	}

	public void setBookingDetails1(List<BookingDetail> bookingDetails1) {
		this.bookingDetails1 = bookingDetails1;
	}

	public BookingDetail addBookingDetails1(BookingDetail bookingDetails1) {
		getBookingDetails1().add(bookingDetails1);
		bookingDetails1.setLoadTerminal(this);

		return bookingDetails1;
	}

	public BookingDetail removeBookingDetails1(BookingDetail bookingDetails1) {
		getBookingDetails1().remove(bookingDetails1);
		bookingDetails1.setPhysicalEntity1(null);

		return bookingDetails1;
	}

	public List<BookingDetail> getBookingDetails2() {
		return this.bookingDetails2;
	}

	public void setBookingDetails2(List<BookingDetail> bookingDetails2) {
		this.bookingDetails2 = bookingDetails2;
	}

	public BookingDetail addBookingDetails2(BookingDetail bookingDetails2) {
		getBookingDetails2().add(bookingDetails2);
		bookingDetails2.setPhysicalEntity2(this);

		return bookingDetails2;
	}

	public BookingDetail removeBookingDetails2(BookingDetail bookingDetails2) {
		getBookingDetails2().remove(bookingDetails2);
		bookingDetails2.setPhysicalEntity2(null);

		return bookingDetails2;
	}

	public List<BookingDetail> getBookingDetails3() {
		return this.bookingDetails3;
	}

	public void setBookingDetails3(List<BookingDetail> bookingDetails3) {
		this.bookingDetails3 = bookingDetails3;
	}

	public BookingDetail addBookingDetails3(BookingDetail bookingDetails3) {
		getBookingDetails3().add(bookingDetails3);
		bookingDetails3.setPhysicalEntity3(this);

		return bookingDetails3;
	}

	public BookingDetail removeBookingDetails3(BookingDetail bookingDetails3) {
		getBookingDetails3().remove(bookingDetails3);
		bookingDetails3.setPhysicalEntity3(null);

		return bookingDetails3;
	}

	public List<BookingDetail> getBookingDetails4() {
		return this.bookingDetails4;
	}

	public void setBookingDetails4(List<BookingDetail> bookingDetails4) {
		this.bookingDetails4 = bookingDetails4;
	}

	public BookingDetail addBookingDetails4(BookingDetail bookingDetails4) {
		getBookingDetails4().add(bookingDetails4);
		bookingDetails4.setPhysicalEntity4(this);

		return bookingDetails4;
	}

	public BookingDetail removeBookingDetails4(BookingDetail bookingDetails4) {
		getBookingDetails4().remove(bookingDetails4);
		bookingDetails4.setPhysicalEntity4(null);

		return bookingDetails4;
	}

	public List<BookingDetail> getBookingDetails5() {
		return this.bookingDetails5;
	}

	public void setBookingDetails5(List<BookingDetail> bookingDetails5) {
		this.bookingDetails5 = bookingDetails5;
	}

	public BookingDetail addBookingDetails5(BookingDetail bookingDetails5) {
		getBookingDetails5().add(bookingDetails5);
		bookingDetails5.setPhysicalEntity5(this);

		return bookingDetails5;
	}

	public BookingDetail removeBookingDetails5(BookingDetail bookingDetails5) {
		getBookingDetails5().remove(bookingDetails5);
		bookingDetails5.setPhysicalEntity5(null);

		return bookingDetails5;
	}

	public List<BookingDetail> getBookingDetails6() {
		return this.bookingDetails6;
	}

	public void setBookingDetails6(List<BookingDetail> bookingDetails6) {
		this.bookingDetails6 = bookingDetails6;
	}

	public BookingDetail addBookingDetails6(BookingDetail bookingDetails6) {
		getBookingDetails6().add(bookingDetails6);
		bookingDetails6.setPhysicalEntity6(this);

		return bookingDetails6;
	}

	public BookingDetail removeBookingDetails6(BookingDetail bookingDetails6) {
		getBookingDetails6().remove(bookingDetails6);
		bookingDetails6.setPhysicalEntity6(null);

		return bookingDetails6;
	}*/

}