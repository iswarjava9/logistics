package com.suis.logistics.service.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.suis.logistics.model.thirdparty.ThirdPartyCustomer;
import com.suis.logistics.model.thirdparty.ThirdPartyCustomerApiResponse;

@Component
public class ZohoCustomerServiceImpl implements ThirdPartyCustomerService {
	@Value("${zoho.auth.token}")
	private String	zohoAuthToken;
	@Autowired
	Environment		env;

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
			String content = EntityUtils.toString(rawResponse.getEntity());
			System.out.println("Create Customer Reponse Content --" + content);
			System.out.println("Create Customer Reponse Status code" + statusCode);
			if (statusCode == 201) {
				ObjectMapper objectMapper = new ObjectMapper();
				ThirdPartyCustomerApiResponse response = objectMapper.readValue(content,
						ThirdPartyCustomerApiResponse.class);
				customerResponse = response.getCustomer();
				System.out.println("CustomerId created in Zoho :" + customerResponse.getCustomerId());
			}
		} catch (IOException e) {
			throw new ThirdPartyCustomerCreationFailedException(e, env);
		}
		return customerResponse;
	}

	private void setHeadersToHttpPostMethod(HttpPost postMethod) {
		postMethod.addHeader("Authorization", zohoAuthToken);
		postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded");
	}
}
