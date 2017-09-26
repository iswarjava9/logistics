/**
 *
 */
/**
 * @author Iswar
 *
 */
@XmlJavaTypeAdapters({ @XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class),
		@XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class) })
package com.suis.logistics.web.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.suis.logistics.common.LocalDateAdapter;
import com.suis.logistics.common.LocalDateTimeAdapter;
