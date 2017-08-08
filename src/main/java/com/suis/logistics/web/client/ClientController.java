package com.suis.logistics.web.client;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.suis.logistics.model.Client;
import com.suis.logistics.service.client.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Resource
	ClientService clientService;
	  
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> registerClient(@RequestBody Client client, UriComponentsBuilder ucBuilder){
        
        clientService.registerClient(client);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	

}
