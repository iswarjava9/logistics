package com.suis.logistics.service.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Client;
import com.suis.logistics.repository.client.ClientDao;

@Component("clientService")
public class ClientServiceImpl implements ClientService{
	
	@Resource
	ClientDao clientDao;
	
	public Integer registerClient(Client client){
		return clientDao.createClient(client);
	}
	
}
