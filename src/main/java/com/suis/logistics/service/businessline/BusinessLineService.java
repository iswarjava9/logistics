package com.suis.logistics.service.businessline;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.BusinessLine;


@Transactional
public interface BusinessLineService {
	public Integer createBusinessLine(BusinessLine businessLine);

	public BusinessLine getBusinessLine(int id);
	public List<BusinessLine> getAllBusinessLines();
}
