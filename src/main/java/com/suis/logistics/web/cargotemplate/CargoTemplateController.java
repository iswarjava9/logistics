package com.suis.logistics.web.cargotemplate;

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

import com.suis.logistics.service.cargo.CargoService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/cargotemplate")
public class CargoTemplateController extends BaseController{

	@Resource
	CargoService cargoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createCargTemplate(@RequestBody CargoTemplateDto cargoTemplateDto) {

		Integer cargoTemplateId = cargoService.createCargoTemplate(converterUtil.convertCargoTemplateDtoToEntity(cargoTemplateDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("cargoTemplateId", String.valueOf(cargoTemplateId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CargoTemplateDto> get(@PathVariable("id") int id) {

		CargoTemplateDto cargoTemplateDto = converterUtil.convertCargoTemplateToDto(cargoService.getCargoTemplate(id));
		return new ResponseEntity<CargoTemplateDto>(cargoTemplateDto, HttpStatus.OK);
	}

}
