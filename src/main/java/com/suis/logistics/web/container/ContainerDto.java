package com.suis.logistics.web.container;

import java.util.List;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.ContainerType;
import com.suis.logistics.model.Quotation;

public class ContainerDto {
	private int				id;
	private String			containerNo;
	private String			equipment;
	private double			grossKgs;
	private double			grossLbs;
	private String			seal1;
	private String			seal2;
	private String			seal3;
	private double			tareKgs;
	private double			tareLbs;
	private List<Cargo>		cargos;
	private BookingDetail	bookingDetail;
	private ContainerType	containerType;
	private Quotation		quotation;
}
