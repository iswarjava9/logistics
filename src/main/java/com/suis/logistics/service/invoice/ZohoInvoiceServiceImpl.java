package com.suis.logistics.service.invoice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.CustomField;
import com.suis.logistics.repository.invoice.CustomFieldDao;
import com.suis.logistics.web.booking.BookingDto;

@Component
public class ZohoInvoiceServiceImpl implements InvoiceService {
	@Value("${zoho.auth.token}")
	private String	zohoAuthToken;
	@Value("${zoho.lineitem.id}")
	private String	zohoLineItemId;
	@Resource
	CustomFieldDao	customFieldDao;
	@Autowired
	Environment		env;

	@Override
	public Invoice createDraftInvoice(BookingDto bookingDto) {
		List<CustomField> customFields = customFieldDao.findAllCustomFields();
		Invoice invoice = new Invoice();
		populateInvoiceFromBookingDetail(bookingDto, invoice);
		populateInvoiceWithLineItems(invoice);
		populateInvoiceWithCustomFields(customFields, bookingDto, invoice);
		return createDraftInvoiceInZohoBooks(invoice);
	}

	private Invoice createDraftInvoiceInZohoBooks(Invoice invoice) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		InvoiceResponse entity = null;
		try {
			mapper.findAndRegisterModules();
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(invoice);
			System.out.println(jsonInString);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("JSONString", jsonInString));
			urlParameters.add(new BasicNameValuePair("ignore_auto_number_generation", "true"));
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/invoices");
			postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));
			setHeadersToHttpPostMethod(postMethod);
			HttpResponse rawResponse = httpClient.execute(postMethod);
			StatusLine statusLine = rawResponse.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			String content = EntityUtils.toString(rawResponse.getEntity());
			System.out.println("Reponse Content --" + content);
			System.out.println("Status code" + statusCode);
			if (statusCode == 201) {
				ObjectMapper objectMapper = new ObjectMapper();
				entity = objectMapper.readValue(content, InvoiceResponse.class);
			} else {
				throw new InvoiceCreationFailedException(content, env);
			}
		} catch (IOException e) {
			throw new InvoiceCreationFailedException(e, env);
		}
		return entity.getInvoice();
	}

	private void populateInvoiceWithCustomFields(List<CustomField> customFields, BookingDto bookingDto,
			Invoice invoice) {
		for (CustomField customField : customFields) {
			customField.setValueFromBookingDetail(bookingDto);
		}
		invoice.setCustom_fields(customFields);
	}

	private void populateInvoiceFromBookingDetail(BookingDto bookingDto, Invoice invoice) {
		invoice.setTemplate_id("945775000000063519");
		invoice.setInvoice_number(bookingDto.getForwarderRefNo());
		invoice.setCustomer_id(bookingDto.getBillTo().getTpCustomerId());
	}

	private void populateInvoiceWithLineItems(Invoice invoice) {
		List<LineItem> lineItems = new ArrayList<>();
		LineItem lineItem = new LineItem();
		lineItem.setItem_id(zohoLineItemId);
		lineItems.add(lineItem);
		invoice.setLine_items(lineItems);
	}

	private void setHeadersToHttpPostMethod(HttpPost postMethod) {
		postMethod.addHeader("Authorization", zohoAuthToken);
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
	}
}
