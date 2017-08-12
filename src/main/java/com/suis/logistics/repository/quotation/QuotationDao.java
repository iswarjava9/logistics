package com.suis.logistics.repository.quotation;

import com.suis.logistics.model.Quotation;

public interface QuotationDao {
	public Integer createQuotation(Quotation quotation);

	public Quotation getQuotation(int id);
}
