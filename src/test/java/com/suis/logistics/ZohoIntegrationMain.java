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
import com.suis.logistics.service.invoice.InvoiceResponse;

public class ZohoIntegrationMain {

	public static void main(String[] args) throws Exception {
		callHttpPostWithFormData(); // creating invoice
	}

	public static void callHttpPostWithHttpParams() throws Exception{
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

	public static void callHttpPostWithFormData() throws Exception{

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("JSONString", "{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }"));
		final HttpClient httpClient = new DefaultHttpClient();
		StringEntity requestEntity = new StringEntity(
				"{ \"customer_id\": \"905339000000061017\",   \"line_items\": [         { \"item_id\": \"905339000000061009\"  }   ] }");


		HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/invoices");

		postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));
		postMethod.addHeader("Authorization", "5bd8628dece544df4d7e9f20305c41ab");
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
		HttpResponse rawResponse = httpClient.execute(postMethod);

		StatusLine statusLine = rawResponse.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		String content = EntityUtils.toString(rawResponse.getEntity());
		System.out.println("Reponse Content --"+content);
		System.out.println("Status code"+statusCode);

		ObjectMapper objectMapper = new ObjectMapper();
		InvoiceResponse entity = objectMapper.readValue(content, InvoiceResponse.class);

		System.out.println(entity);
	}

}
