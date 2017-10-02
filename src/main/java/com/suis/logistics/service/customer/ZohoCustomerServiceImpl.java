package com.suis.logistics.service.customer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.thirdparty.ThirdPartyCustomer;
import com.suis.logistics.model.thirdparty.ThirdPartyCustomerApiResponse;

@Component
public class ZohoCustomerServiceImpl implements ThirdPartyCustomerService {

	@Override
	public ThirdPartyCustomer createCustomer(ThirdPartyCustomer customer) {

		ObjectMapper mapper = new ObjectMapper();
		ThirdPartyCustomer customerResponse = null;
		String jsonInString = null;
		try {
			mapper.findAndRegisterModules();
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
			System.out.println("------------ThirdPartyCustomer JsonString as Request : ----------- " + jsonInString);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("JSONString", jsonInString));
			final HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost postMethod = new HttpPost("https://books.zoho.com/api/v3/contacts");
			postMethod.setEntity(new UrlEncodedFormEntity(urlParameters));
			setHeadersToHttpPostMethod(postMethod);
			HttpResponse rawResponse = httpClient.execute(postMethod);
			StatusLine statusLine = rawResponse.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 201) {
				String content = EntityUtils.toString(rawResponse.getEntity());
				System.out.println("Create Customer Reponse Content --" + content);
				System.out.println("Create Customer Reponse Status code" + statusCode);
				ObjectMapper objectMapper = new ObjectMapper();
				ThirdPartyCustomerApiResponse response = objectMapper.readValue(content,
						ThirdPartyCustomerApiResponse.class);
				customerResponse = response.getCustomer();
				System.out.println("CustomerId created in Zoho :" + customerResponse.getCustomerId());
			}
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return customerResponse;
	}

	private void setHeadersToHttpPostMethod(HttpPost postMethod) {
		postMethod.addHeader("Authorization", "8880f37667c7fae1895980914320fef0");
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
	}
}
