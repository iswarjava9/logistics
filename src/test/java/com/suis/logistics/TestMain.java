package com.suis.logistics;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.suis.logistics.common.HibernateConfiguration;
import com.suis.logistics.model.Client;
import com.suis.logistics.repository.client.ClientDao;
import com.suis.logistics.service.booking.BookingService;

public class TestMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
getBookingList(context);
	}

	public static void getBookingList(AbstractApplicationContext context){
		BookingService service = (BookingService) context.getBean("bookingServiceImpl");
		System.out.println(service.getBookingList());
	}

	public static void clientEntityOperation(AbstractApplicationContext context){
		ClientDao service = (ClientDao) context.getBean("clientDaoImpl");
		Client client = new Client();
		client.setName("A4");
		client.setCreatedDate(new Date());
		client.setUpdatedDate(new Date());
		service.createClient(client);
	}
}
