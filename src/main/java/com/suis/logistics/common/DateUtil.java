package com.suis.logistics.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public LocalDateTime convertDateToSpecificTimeZone(LocalDateTime date,String timeZoneId){

		ZonedDateTime current = date.atZone(ZoneId.systemDefault());
		System.out.println(current);
		ZonedDateTime zdt = current.withZoneSameInstant(ZoneId.of(timeZoneId));
		System.out.println(zdt.toLocalDateTime());
		return zdt.toLocalDateTime();
	}

}
