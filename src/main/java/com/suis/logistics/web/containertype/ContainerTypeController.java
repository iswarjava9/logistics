package com.suis.logistics.web.containertype;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.container.ContainerService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/containertype")
public class ContainerTypeController extends BaseController {
	@Resource
	ContainerService containerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createContainerType(@RequestBody ContainerTypeDto containerTypeDto) {
		Integer containerTypeId = containerService.createContainerType(converterUtil.convertContainerTypeDtoToEntity(containerTypeDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("containerTypeId", String.valueOf(containerTypeId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ContainerTypeDto> get(@PathVariable("id") int id) {
		ContainerTypeDto containerTypeDto = converterUtil.convertContainerTypeToDto(containerService.getContainerType(id));
		return new ResponseEntity<ContainerTypeDto>(containerTypeDto, HttpStatus.OK);
	}
}
