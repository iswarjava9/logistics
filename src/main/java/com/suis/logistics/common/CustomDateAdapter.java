package com.suis.logistics.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomDateAdapter extends  XmlAdapter<String, LocalDateTime> {

	@Override
	public String marshal(LocalDateTime v) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateAsString = v.format(formatter);

		return dateAsString;
	}

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime date = LocalDateTime.parse(v, formatter);
		return date;
	}

}
