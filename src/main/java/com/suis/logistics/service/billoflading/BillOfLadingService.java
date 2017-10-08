package com.suis.logistics.service.billoflading;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.BillOfLading;

@Transactional
public interface BillOfLadingService {
	public BillOfLading getBillOfLading(int id);
	public BillOfLading createBillOfLading(BillOfLading billOfLading);
	public BillOfLading updateBillOfLading(BillOfLading billOfLading);
	public InputStream downloadBillOfLading(String blNo, HttpHeaders headers) throws IOException;
	
}
