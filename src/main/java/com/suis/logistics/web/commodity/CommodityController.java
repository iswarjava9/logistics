package com.suis.logistics.web.commodity;

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

import com.suis.logistics.service.commodity.CommodityService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/commodity")
public class CommodityController extends BaseController {
@Resource
CommodityService commodityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createBooking(@RequestBody CommodityDto commodityDto) {
		Integer commodityId = commodityService.createCommodity(converterUtil.convertCommodityDtoToEntity(commodityDto));
		HttpHeaders headers = new HttpHeaders();
		headers.set("commodityId", String.valueOf(commodityId));
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@Transactional
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<CommodityDto> get(@PathVariable("id") int id) {
		CommodityDto commodityDto = converterUtil.convertCommodityToDto(commodityService.getCommodity(id));
		return new ResponseEntity<CommodityDto>(commodityDto, HttpStatus.OK);
	}
}
