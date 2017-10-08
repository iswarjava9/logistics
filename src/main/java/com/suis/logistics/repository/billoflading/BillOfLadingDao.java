package com.suis.logistics.repository.billoflading;

import com.suis.logistics.model.BillOfLading;

public interface BillOfLadingDao {
	public BillOfLading createBillOfLading(BillOfLading billOfLading);
	public BillOfLading updateBillOfLading(BillOfLading billOfLading);
	public BillOfLading findById(int id);

}
