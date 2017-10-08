package com.suis.logistics.service.billoflading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.suis.logistics.model.BillOfLading;
import com.suis.logistics.repository.billoflading.BillOfLadingDao;

@Component
public class BillOfLadingServiceImpl implements BillOfLadingService {
	@Value("${booking.pdf.url}")
	private String				bookingPDFUrl;
	
	@Resource
	BillOfLadingDao bolDao;
	@Override
	public BillOfLading createBillOfLading(BillOfLading billOfLading) {
		return bolDao.createBillOfLading(billOfLading);
	}

	@Override
	public BillOfLading updateBillOfLading(BillOfLading billOfLading) {
		return bolDao.updateBillOfLading(billOfLading);
	}

	@Override
	public InputStream downloadBillOfLading(String blNo, HttpHeaders headers) throws IOException {
		File pdf = new File(bookingPDFUrl + "//billoflading-" + blNo + ".pdf");
		/*
		 * ClassPathResource bookingPDF = new ClassPathResource("generated-pdf/"
		 * + pdf.getName());
		 */
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "inline; filename=" + pdf.getName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentLength(pdf.length());
		InputStream billofladingPDF = new FileInputStream(pdf);
		return billofladingPDF;
	}

	@Override
	public BillOfLading getBillOfLading(int id) {
		return bolDao.findById(id);
	}

}
