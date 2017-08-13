package com.suis.logistics.web.cargo;

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
@RequestMapping("/cargo")
public class CargoController extends BaseController {

	@Resource
	CargoService cargoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createCargo(@RequestBody CargoDto cargoDto) {

		Integer cargoId = cargoService.createCargo(converterUtil.convertCargoDtoToEntity(cargoDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("cargoId", String.valueOf(cargoId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CargoDto> get(@PathVariable("id") int id) {

		CargoDto cargoDto = converterUtil.convertCargoToDto(cargoService.getCargo(id));
		return new ResponseEntity<CargoDto>(cargoDto, HttpStatus.OK);
	}
}
