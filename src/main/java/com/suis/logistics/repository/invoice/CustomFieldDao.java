package com.suis.logistics.repository.invoice;

import java.util.List;

import com.suis.logistics.model.CustomField;

public interface CustomFieldDao {

	public List<CustomField> findAllCustomFields();
}
