package com.suis.logistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.suis.logistics.common.HibernateConfiguration;
import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.Client;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.repository.client.ClientDao;
import com.suis.logistics.service.booking.BookingService;
import com.suis.logistics.service.cargo.CargoService;
import com.suis.logistics.service.container.ContainerService;

public class TestMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		createContainer(context);
	}

	public static void getBookingList(AbstractApplicationContext context) {
		BookingService service = (BookingService) context.getBean("bookingServiceImpl");
		System.out.println(service.getBookingList());
	}

	public static void clientEntityOperation(AbstractApplicationContext context) {
		ClientDao service = (ClientDao) context.getBean("clientDaoImpl");
		Client client = new Client();
		client.setName("A4");
		client.setCreatedDate(new Date());
		client.setUpdatedDate(new Date());
		service.createClient(client);
	}

	public static void createContainer(AbstractApplicationContext context) {
		ContainerService conServ = (ContainerService) context.getBean("containerServiceImpl");
		CargoService cargoServ = (CargoService) context.getBean("cargoServiceImpl");

		ContainerDetail containerDetail = new ContainerDetail();
		containerDetail.setContainerNo("CT-00005");

		List<Cargo> cargos = new ArrayList();
		cargos.add(cargoServ.getCargo(1));
		cargos.add(cargoServ.getCargo(2));
		containerDetail.setCargos(cargos);
		/*cg1.setContainerDetail(containerDetail);
		cg2.setContainerDetail(containerDetail);
		containerDetail.addCargo(cg1);
		containerDetail.addCargo(cg2);*/
		conServ.createContainer(containerDetail);
		System.out.println(containerDetail);

	}
}
