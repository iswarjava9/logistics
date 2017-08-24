/**
 *
 */
/**
 * @author Iswar
 *
 */

@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=LocalDateTime.class,
        value=LocalDateTimeAdapter.class)
})
package com.suis.logistics.web;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.suis.logistics.common.LocalDateTimeAdapter;
