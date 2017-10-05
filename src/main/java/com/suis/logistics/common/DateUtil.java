package com.suis.logistics.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.suis.logistics.web.TimeZoneDto;

@Component
public class DateUtil {

	public LocalDateTime convertDateToSpecificTimeZone(LocalDateTime date, String timeZoneId) {
		if (date != null && timeZoneId != null) {
			ZonedDateTime current = date.atZone(ZoneId.systemDefault());
			ZonedDateTime zdt = current.withZoneSameInstant(ZoneId.of(timeZoneId));
			System.out.println("Date Converted from - "+date +" to (timezone: "+timeZoneId+"  - "+ zdt.toLocalDateTime());
			return zdt.toLocalDateTime();
		}
		return null;
	}

	public LocalDateTime convertDateFromSpecifiedTimeZoneToSystemDefaultTimeZone(LocalDateTime dateTime,
			String timeZoneId) {
		if (dateTime != null && timeZoneId != null) {
			ZonedDateTime dateTimeWithZone = dateTime.atZone(ZoneId.of(timeZoneId));
			return dateTimeWithZone.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
		}
		return null;
	}

	public List<TimeZoneDto> getAvailableTimeZones() {
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		List<TimeZoneDto> timeZoneList = new ArrayList<TimeZoneDto>();
		for (String zoneId : zoneIds) {
			ZoneId zone = ZoneId.of(zoneId);
			/*ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
			ZoneOffset offset = zonedDateTime.getOffset();
			String shortDisplayName = TimeZone.getTimeZone(offset).getDisplayName(false, TimeZone.SHORT);*/
			TimeZoneDto timeZone = new TimeZoneDto(zone.getId());
			timeZoneList.add(timeZone);
		}
		return timeZoneList;
	}
}
