package com.suis.logistics.web.movementtype;

import java.util.List;

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

import com.suis.logistics.service.movementtype.MovementTypeService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/movementtype")
public class MovementTypeController extends BaseController {

	@Resource
	MovementTypeService movementTypeService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createMovementType(@RequestBody MovementTypeDto movementTypeDto) {

		Integer movementTypeId = movementTypeService.createMovementType(converterUtil.convertMovementTypeDtoToEntity(movementTypeDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("movementTypeId", String.valueOf(movementTypeId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<MovementTypeDto> get(@PathVariable("id") int id) {

		MovementTypeDto movementTypeDto = converterUtil.convertMovementTypeToDto(movementTypeService.getMovementType(id));
		return new ResponseEntity<MovementTypeDto>(movementTypeDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<MovementTypeDto>> getMovementTypes() {
		List<MovementTypeDto> movementTypes = converterUtil.convertMovementTypeListToDto(movementTypeService.getAllMovementTypes());
		return new ResponseEntity<List<MovementTypeDto>>(movementTypes, HttpStatus.OK);
	}
}
