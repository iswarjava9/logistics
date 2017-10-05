package com.suis.logistics.service.invoice;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
import com.suis.logistics.web.container.ContainerDto;

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
			System.out.println("Invoice JSONString : " + jsonInString);
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
			System.out.println("Invoice Response Content --" + content);
			System.out.println("Invoice Response Status code" + statusCode);
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
			customField.setValueFromBookingDetail(buildContainerTextForInvoice(bookingDto));
		}
		invoice.setCustom_fields(customFields);
	}

	private CustomFieldsValue buildContainerTextForInvoice(BookingDto bookingDto) {
		StringBuilder containersTextTemp = new StringBuilder("");
		StringBuilder commodityText = new StringBuilder("");
		Double totalWeightInKg = 0.0;
		Double totalWeightInLb = 0.0;
		String shippmentDetails = "";
		String containersText = "";
		String totalWeightText = "";
		int count = 1;
		for (ContainerDto containerDto : bookingDto.getContainerDetails()) {
			totalWeightInKg = totalWeightInKg + containerDto.getTareKgs();
			totalWeightInLb = totalWeightInLb + containerDto.getTareLbs();
			if (count != 1) {
				containersTextTemp.append(", ");
			}
			containersTextTemp.append(containerDto.getContainerNo()).append(" / ").append(containerDto.getSeal1());
			if (count == 1) {

				commodityText.append(containerDto.getCommodity().getName());
			} else if (!commodityText.toString().contains(containerDto.getCommodity().getName())) {
				commodityText.append(", ");
				commodityText.append(containerDto.getCommodity().getName());
			}
			count++;
		}
		shippmentDetails = commodityText.toString();
		containersText = containersTextTemp.toString();
		totalWeightText = totalWeightInKg + " Kgs " + totalWeightInLb + " Lbs";
		CustomFieldsValue customFieldsValue = new CustomFieldsValue();
		customFieldsValue.setHblValue(bookingDto.getForwarderRefNo());
		customFieldsValue.setShipperNameValue(bookingDto.getShipper().getName());
		customFieldsValue
				.setVesselVoyageValue(bookingDto.getVessel().getName() + " / " + bookingDto.getCarrierVoyage());
		customFieldsValue.setContainerSealValue(containersText);
		customFieldsValue.setPortOfLoadingValue(bookingDto.getPortOfLoad().getName());
		customFieldsValue.setPortOfDischargeValue(
				bookingDto.getPortOfDischarge() != null ? bookingDto.getPortOfDischarge().getName()
						: "NA" + " / " + bookingDto.getPlaceOfDelivery() != null
								? bookingDto.getPlaceOfDelivery().getName() : "NA");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDateTime = bookingDto.getEta().format(formatter);
		customFieldsValue.setEtaValue(formatDateTime);
		customFieldsValue.setCargoWeightValue(totalWeightText);
		customFieldsValue.setShipmentDetailsValue(shippmentDetails);
		return customFieldsValue;
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
