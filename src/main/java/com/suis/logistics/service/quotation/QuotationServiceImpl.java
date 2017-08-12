package com.suis.logistics.service.quotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Quotation;
import com.suis.logistics.repository.quotation.QuotationDao;

@Component
public class QuotationServiceImpl implements QuotationService {
	@Resource
	QuotationDao quotationDao;

	@Override
	public Integer createQuotation(Quotation quotation) {
		return quotationDao.createQuotation(quotation);
	}

	@Override
	public Quotation getQuotation(int id) {
		return quotationDao.getQuotation(id);
	}

}
