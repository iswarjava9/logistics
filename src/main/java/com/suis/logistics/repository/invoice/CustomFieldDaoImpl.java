package com.suis.logistics.repository.invoice;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.CustomField;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CustomFieldDaoImpl extends BaseDao implements CustomFieldDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomField> findAllCustomFields() {
		List<CustomField> customFields = getCurrentSession().createCriteria(CustomField.class)
				.addOrder(Order.asc("index")).list();
		return customFields;
	}
}
