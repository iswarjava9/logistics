package com.suis.logistics.web.piecetype;

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

import com.suis.logistics.service.piecetype.PieceTypeService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/piecetype")
public class PieceTypeController extends BaseController {

	@Resource
	PieceTypeService pieceTypeService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createPieceType(@RequestBody PieceTypeDto pieceTypeDto) {

		Integer pieceTypeId = pieceTypeService.createPieceType(converterUtil.convertPieceTypeDtoToEntity(pieceTypeDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("pieceTypeId", String.valueOf(pieceTypeId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<PieceTypeDto> get(@PathVariable("id") int id) {

		PieceTypeDto pieceTypeDto = converterUtil.convertPieceTypeToDto(pieceTypeService.getPieceType(id));
		return new ResponseEntity<PieceTypeDto>(pieceTypeDto, HttpStatus.OK);
	}
}
