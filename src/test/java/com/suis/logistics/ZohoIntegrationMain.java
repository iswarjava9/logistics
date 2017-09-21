package com.suis.logistics;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.service.invoice.CustomField;
import com.suis.logistics.service.invoice.Invoice;
import com.suis.logistics.service.invoice.InvoiceResponse;
import com.suis.logistics.service.invoice.LineItem;

public class ZohoIntegrationMain {

	public static void main(String[] args) throws Exception {
		// callHttpPostWithFormData(); // creating invoice
		createCreateInvoiceInZoho_V2();
	}

	public static void callHttpPostWithHttpParams() throws Exception {
		final HttpClient httpClient = new DefaultHttpClient();
		StringEntity requestEntity = new StringEntity(
				"{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }");
		HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/invoices");
		HttpParams params = new BasicHttpParams();
		params.setParameter("JSONString",
				"{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }");
		postMethod.setParams(params);
		postMethod.addHeader("Authorization", "5bd8628dece544df4d7e9f20305c41ab");
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
		HttpResponse rawResponse = httpClient.execute(postMethod);
		System.out.println(rawResponse);
	}

	public static void setHeadersToHttpPostMethod(HttpPost postMethod) {
		postMethod.addHeader("Authorization", "8880f37667c7fae1895980914320fef0");
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
	}

	/**
	 * This method is used to create Invoice in Zoho
	 *
	 * @throws Exception
	 */
	public static void callHttpPostWithFormData() throws Exception {

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("JSONString",
				"{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }"));
		final HttpClient httpClient = new DefaultHttpClient();
		/*
		 * StringEntity requestEntity = new StringEntity(
		 * "{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }"
		 * );
		 */
		HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/invoices");
		postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));
		setHeadersToHttpPostMethod(postMethod);
		HttpResponse rawResponse = httpClient.execute(postMethod);
		StatusLine statusLine = rawResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		String content = EntityUtils.toString(rawResponse.getEntity());
		System.out.println("Reponse Content --" + content);
		System.out.println("Status code" + statusCode);
		ObjectMapper objectMapper = new ObjectMapper();
		InvoiceResponse entity = objectMapper.readValue(content, InvoiceResponse.class);
		System.out.println(entity);
	}

	public static void createCreateInvoiceInZoho_V1() throws Exception {
		callHttpPostWithFormData();
	}

	public static void createCreateInvoiceInZoho_V2() throws Exception {

		Invoice invoice = new Invoice();
		invoice.setCustomer_id("853113000000075001");
		invoice.setExchange_rate(20.0);
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem1 = new LineItem();
		lineItem1.setItem_id("853113000000086343");
		lineItem1.setRate(100.00);
		lineItem1.setPurchase_rate(50.00);
		lineItem1.setQuantity(1.0);
		lineItems.add(lineItem1);
		LineItem lineItem2 = new LineItem();
		lineItem2.setItem_id("853113000000086393");
		lineItem2.setRate(200.00);
		lineItem2.setPurchase_rate(100.00);
		lineItem2.setQuantity(2.0);
		lineItems.add(lineItem2);
		invoice.setLine_items(lineItems);
		populateCustomFields(invoice);
		// convert to json string
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(invoice);
		System.out.println(jsonInString);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("JSONString", jsonInString));
		final HttpClient httpClient = new DefaultHttpClient();
		/*
		 * StringEntity requestEntity = new StringEntity(
		 * "{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }"
		 * );
		 */
		HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/invoices");
		postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));
		setHeadersToHttpPostMethod(postMethod);
		HttpResponse rawResponse = httpClient.execute(postMethod);
		StatusLine statusLine = rawResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		String content = EntityUtils.toString(rawResponse.getEntity());
		System.out.println("Reponse Content --" + content);
		System.out.println("Status code" + statusCode);
		ObjectMapper objectMapper = new ObjectMapper();
		InvoiceResponse entity = objectMapper.readValue(content, InvoiceResponse.class);
		System.out.println(entity);
	}

	public static void populateCustomFields(Invoice invoice) {

		List<CustomField> customFields = new ArrayList<>();
		CustomField customField1 = new CustomField();
		customField1.setCustomfield_id("853113000000077057");
		customField1.setValue("PO# 20172224/19230, 20172516 / 19231");
		customFields.add(customField1);
		//
		CustomField customField2 = new CustomField();
		customField2.setCustomfield_id("853113000000075073");
		customField2.setValue("HBL NO: H97681530003");
		customFields.add(customField2);
		//
		CustomField customField3 = new CustomField();
		customField1.setCustomfield_id("853113000000075071");
		customField1.setValue("REMET UK LTD");
		customFields.add(customField3);
		//
		CustomField customField4 = new CustomField();
		customField1.setCustomfield_id("853113000000061021");
		customField1.setValue("YM WELLNESS");
		customFields.add(customField4);
		//
		CustomField customField5 = new CustomField();
		customField1.setCustomfield_id("853113000000061019");
		customField1.setValue("TCLU8831858 /EUR787339");
		customFields.add(customField5);
		//
		CustomField customField6 = new CustomField();
		customField1.setCustomfield_id("853113000000061013");
		customField1.setValue("LONDON GATEWAY PORT");
		customFields.add(customField6);
		//
		CustomField customField7 = new CustomField();
		customField1.setCustomfield_id("853113000000081019");
		customField1.setValue("CHENNAI / CHENNAI");
		customFields.add(customField7);
		//
		CustomField customField8 = new CustomField();
		customField1.setCustomfield_id("853113000000078293");
		customField1.setValue("2017-09-01");
		customFields.add(customField8);
		//
		CustomField customField9 = new CustomField();
		customField1.setCustomfield_id("853113000000079023");
		customField1.setValue(
				"ARTIFICIAL & PREPARED WAXES FASTFORM TXO, PREPARED FOUNDRY BINDERS ADBOND ULTRA CONCENTRATE /  4987.72 KGS/ 11.170 CBM");
		customFields.add(customField9);


		invoice.setCustom_fields(customFields);
	}
}
