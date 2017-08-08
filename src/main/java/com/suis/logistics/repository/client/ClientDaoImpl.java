package com.suis.logistics.repository.client;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Client;
import com.suis.logistics.repository.BaseDao;

@Repository
public class ClientDaoImpl extends BaseDao implements ClientDao {

	
	@Override
	public Integer createClient(Client client) {		
		getCurrentSession().save(client);
		return client.getId();
	}
	
	@Override
	public Client findById(Integer clientId) {
		return getCurrentSession().load(Client.class, clientId);		
	}
	
}
