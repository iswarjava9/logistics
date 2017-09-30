package com.suis.logistics;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suis.logistics.model.TimeZoneApiResponse;

@Component
public class TimeZoneAPIintegrationMain {

	public static void main(String[] args) throws Exception {
		getTimeZones("FR","Shid");
	}

	public static TimeZoneApiResponse getTimeZones(String countryCode,String city) throws Exception {

		final HttpClient httpClient = HttpClientBuilder.create().build();

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

		urlParameters.add(new BasicNameValuePair("key", "PXRJC63IPDXV"));
		urlParameters.add(new BasicNameValuePair("format", "json"));
		urlParameters.add(new BasicNameValuePair("by", "city"));
		urlParameters.add(new BasicNameValuePair("country", countryCode));
		urlParameters.add(new BasicNameValuePair("city", city));
		//HttpGet httpGet = new HttpGet("http://api.timezonedb.com/v2/list-time-zone");

		HttpGet httpGet = new HttpGet("http://vip.timezonedb.com/v2/get-time-zone");
		URI uri = new URIBuilder(httpGet.getURI()).addParameters(urlParameters).build();
		httpGet.setURI(uri);

		//Thread.sleep(10000);
		HttpResponse rawResponse = httpClient.execute(httpGet);


		String content = EntityUtils.toString(rawResponse.getEntity());
		ObjectMapper objectMapper = new ObjectMapper();
		TimeZoneApiResponse entity = objectMapper.readValue(content, TimeZoneApiResponse.class);
		System.out.println(content);

		return entity;
	}
}
