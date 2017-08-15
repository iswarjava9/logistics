package com.suis.logistics.repository.quotation;

import java.util.List;

import com.suis.logistics.model.Quotation;

public interface QuotationDao {
	public Integer createQuotation(Quotation quotation);

	public Quotation getQuotation(int id);

	public List<Quotation> getQuotations();
}
