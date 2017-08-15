package com.suis.logistics.repository.quotation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Quotation> getQuotations() {
		Criteria cr = getCurrentSession().createCriteria(Quotation.class)
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("customerRefNo"), "customerRefNo")
						.add(Projections.property("effectiveDate"), "effectiveDate")
						.add(Projections.property("expirationDate"), "expirationDate"))
				.setResultTransformer(Transformers.aliasToBean(Quotation.class));
		List<Quotation> quotations = cr.list();
		return quotations;
	}

}
