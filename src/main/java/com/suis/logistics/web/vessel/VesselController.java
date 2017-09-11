package com.suis.logistics.web.vessel;

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

import com.suis.logistics.service.vessel.VesselService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/vessel")
public class VesselController extends BaseController {

	@Resource
	VesselService vesselService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createVessel(@RequestBody VesselDto vesselDto) {

		Integer vesselId = vesselService.createVessel(converterUtil.convertVesselDtoToEntity(vesselDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("vesselId", String.valueOf(vesselId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<VesselDto> get(@PathVariable("id") int id) {

		VesselDto vesselDto = converterUtil.convertVesselToDto(vesselService.getVessel(id));
		return new ResponseEntity<VesselDto>(vesselDto, HttpStatus.OK);
	}

	@Transactional
	@RequestMapping(value = "byname/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<VesselDto>> getAllVesselsByName(@PathVariable("name") String name) {
		List<VesselDto> vessels = converterUtil.convertVesselListToDto(vesselService.getVesselsByName(name));
		return new ResponseEntity<List<VesselDto>>(vessels, HttpStatus.OK);
	}
}
