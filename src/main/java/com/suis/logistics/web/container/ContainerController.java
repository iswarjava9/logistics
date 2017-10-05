package com.suis.logistics.web.container;

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

import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.service.cargo.CargoService;
import com.suis.logistics.service.container.ContainerService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/container")
public class ContainerController extends BaseController {
	@Resource
	ContainerService	containerService;
	@Resource
	CargoService		cargoService;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createContainer(@RequestBody ContainerDto containerDto) {
		ContainerDetail containerDetail = converterUtil.convertContainerDtoToEntity(containerDto);
		Integer containerId = containerService.createContainer(containerDetail);
		HttpHeaders headers = new HttpHeaders();
		headers.set("containerId", String.valueOf(containerId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ContainerDto> updateContainer(@RequestBody ContainerDto containerDto) {
		ContainerDetail containerDetail = converterUtil.convertContainerDtoToEntity(containerDto);
		ContainerDto container = converterUtil.convertContainerToDto(containerService.updateContainer(containerDetail));

		return new ResponseEntity<ContainerDto>(container, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<ContainerDto> get(@PathVariable("id") int id) {
		ContainerDto containerDto = converterUtil.convertContainerToDto(containerService.getContainer(id));
		return new ResponseEntity<ContainerDto>(containerDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ContainerDto> delete(@PathVariable("id") int id) {
		ContainerDto containerDto = converterUtil.convertContainerToDto(containerService.deleteContainer(id));
		return new ResponseEntity<ContainerDto>(containerDto, HttpStatus.OK);
	}
}
