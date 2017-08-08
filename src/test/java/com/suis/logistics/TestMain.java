package com.suis.logistics;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.suis.logistics.common.HibernateConfiguration;
import com.suis.logistics.model.Client;
import com.suis.logistics.repository.client.ClientDao;

public class TestMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		ClientDao service = (ClientDao) context.getBean("clientDaoImpl");
		Client client = new Client();
		client.setName("A4");
		client.setCreatedDate(new Date());
		client.setUpdatedDate(new Date());
		service.createClient(client);
	}
}
