package com.suis.logistics.repository.businessline;

import com.suis.logistics.model.BusinessLine;

public interface BusinessLineDao {

	public Integer createBusinessLine(BusinessLine businessLine);

	public BusinessLine findById(int businessId);

}
