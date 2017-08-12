package com.suis.logistics.repository.quotation;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.Quotation;
import com.suis.logistics.repository.BaseDao;

@Repository
public class QuotationDaoImpl extends BaseDao implements QuotationDao {

	@Override
	public Integer createQuotation(Quotation quotation) {
		getCurrentSession().save(quotation);
		return quotation.getId();
	}

	@Override
	public Quotation getQuotation(int quotationId) {
		return getCurrentSession().load(Quotation.class, quotationId);
	}

}
