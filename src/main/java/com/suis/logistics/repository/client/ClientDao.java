package com.suis.logistics.repository.client;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Client;

@Transactional
public interface ClientDao {
	
	public Integer createClient(Client client);
	
	public Client findById(Integer clientId);


}
