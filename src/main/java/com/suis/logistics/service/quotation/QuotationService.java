package com.suis.logistics.service.quotation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Quotation;

@Component
@Transactional
public interface QuotationService {
	public Integer createQuotation(Quotation quotation);

	public Quotation getQuotation(int id);
}
