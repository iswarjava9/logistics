package com.suis.logistics.web.container;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.service.container.ContainerService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/container")
public class ContainerController extends BaseController {
	@Resource
	ContainerService containerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createContainer(@RequestBody ContainerDto containerDto) {
		Integer containerId = containerService.createContainer(converterUtil.convertContainerDtoToEntity(containerDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("businessLineId", String.valueOf(containerId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ContainerDto> get(@PathVariable("id") int id) {
		ContainerDto containerDto = converterUtil.convertContainerToDto(containerService.getContainer(id));
		return new ResponseEntity<ContainerDto>(containerDto, HttpStatus.OK);
	}
}
