package com.suis.logistics.repository.businessline;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BusinessLine;
import com.suis.logistics.repository.BaseDao;

@Repository
public class BusinessLineDaoImpl extends BaseDao implements BusinessLineDao {

	@Override
	public Integer createBusinessLine(BusinessLine businessLine) {
		getCurrentSession().save(businessLine);
		return businessLine.getId();
	}

	@Override
	public BusinessLine findById(int businessId) {

		return getCurrentSession().load(BusinessLine.class, businessId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessLine> getAllBusinessLines() {
		Query query = getCurrentSession().getNamedQuery("BusinessLine.findAll");
		List<BusinessLine> businessLines = query.list();
		return businessLines;
	}
}
