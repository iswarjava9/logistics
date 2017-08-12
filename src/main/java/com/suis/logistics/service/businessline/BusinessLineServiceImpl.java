package com.suis.logistics.service.businessline;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.BusinessLine;
import com.suis.logistics.repository.businessline.BusinessLineDao;

@Component
public class BusinessLineServiceImpl implements BusinessLineService {

	@Resource
	BusinessLineDao businessLineDao;

	@Override
	public Integer createBusinessLine(BusinessLine businessLine) {
		return businessLineDao.createBusinessLine(businessLine);
	}

	@Override
	public BusinessLine getBusinessLine(int id) {
		return businessLineDao.findById(id);
	}
}
